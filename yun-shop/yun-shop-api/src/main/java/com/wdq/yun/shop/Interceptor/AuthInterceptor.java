//package com.wdq.yun.shop.Interceptor;
//
//import com.fkhwl.fkhserver.commons.enums.RespCode;
//import com.fkhwl.fkhserver.commons.util.MD5;
//import com.fkhwl.fkhserver.component.redis.interfaces.RedisCachedService;
//import com.fkhwl.fkhserver.domain.exceptions.DataValidateException;
//import com.wdq.yun.common.utils.MD5;
//
//import org.apache.commons.lang.StringUtils;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * @author wudq
// * @date 2019/1/3
// * @Description: api token认证
// * 1、若请求是/auth申请token，校验apiKey(公钥)，根据apiSecret(私钥)生成JWT_TOKEN并响应请求
// * 2、不是申请token的请求,校验JWT_TOKEN（待完善）
// * 3、token校验成功，校验参数签名sign
// */
//@Slf4j
//@Component
//public class AuthInterceptor extends HandlerInterceptorAdapter {
//
//    private static final String JWT_TOKEN_REDIS_KEY = "zhongqi_jwt_token";
//    private static final String AUTH_URI = "/fkhapizq/auth";
//
//    private static final String REQUEST_SIGN = "sign";
//
//    private String apiKey;
//
//    private String apiSecret;
//
//    private RedisCachedService cachedService;
//
//    public AuthInterceptor(String apiKey, String apiSecret, RedisCachedService cachedService){
//        this.apiKey = apiKey;
//        this.apiSecret = apiSecret;
//        this.cachedService = cachedService;
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        String requestURI=request.getRequestURI();
//        String authToken = request.getHeader("Authorization");
//        //请求为获取JWT token，校验apiKey
//        if(AUTH_URI.equals(requestURI)) {
//            //token不能为空
//            if(StringUtils.isEmpty(authToken)) {
//                throw new DataValidateException(RespCode.INVALID_TOKEN.getCode(),RespCode.INVALID_TOKEN.getMessage());
//            }
//            //apiKey 公钥错误
//            if (!apiKey.equals(authToken)) {
//                throw new DataValidateException(RespCode.INVALID_TOKEN.getCode(),RespCode.INVALID_TOKEN.getMessage());
//            }
//            this.checkSign(request);
//            return true;
//
//        }else {
//
//            String jwtToken  = (String) cachedService.get(JWT_TOKEN_REDIS_KEY);
//            if(StringUtils.isEmpty(authToken)) {
//                //token不能为空
//                throw new DataValidateException(RespCode.INVALID_TOKEN.getCode(),RespCode.INVALID_TOKEN.getMessage());
//            }
//            if(StringUtils.isEmpty(jwtToken)) {
//                //服务器缓存token过期
//                throw new DataValidateException(RespCode.TOKEN_EXPIRED.getCode(),"Token过期");
//            }
//            if(!jwtToken.equals(authToken)) {
//                //无效的Token
//                throw new DataValidateException(RespCode.INVALID_TOKEN.getCode(),RespCode.INVALID_TOKEN.getMessage());
//            }
//            this.checkSign(request);
//        }
//
//        return true;
//    }
//
//    /**
//     * 签名检查
//     *
//     * @param request
//     * @return
//     */
//    private boolean checkSign(HttpServletRequest request) {
//        String sign = this.getSign(request);
//        //sign
//        Map<String, String[]> paramMap = request.getParameterMap();
//        String[] authSign = paramMap.get(REQUEST_SIGN);
//        if (authSign.length == 0) {
//            //签名不能为空
//            throw new DataValidateException(RespCode.SIGN_ERROR.getCode(),RespCode.SIGN_ERROR.getMessage());
//        }
//        if (!sign.equals(authSign[0])) {
//            throw new DataValidateException(RespCode.SIGN_ERROR.getCode(),RespCode.SIGN_ERROR.getMessage());
//        }
//        log.info("签名验证通过，请求路径 = {},sign = {}",request.getRequestURI(),sign);
//        return true;
//    }
//
//
//    /**
//     * 获取参数签名
//     * sign = md5(requestURI(/fkhapizq/控制器名/方法名) + 参数拼接串 + '加密公钥(apiKey)')
//     *
//     * @param request
//     * @return
//     */
//    private String getSign(HttpServletRequest request) {
//        //requestURI
//        String requestURI=request.getRequestURI();
//        //拼接参数
//        String params = this.getSignParams(request);
//        //签名加密串
//        String md5Src = requestURI + params + apiKey;
//        String sign = MD5.md5(md5Src);
//        return sign;
//    }
//
//
//    /**
//     * 参数拼接
//     * params = "key1=value1&key2=value2"
//     * @param request
//     * @return
//     */
//    private String getSignParams(HttpServletRequest request) {
//        //第一步:获取所有请求参数
//        Map<String, String[]> multiValueMap = request.getParameterMap();
//
//        //第二步,定义List用于存储所有请求参数的key
//        List<String> keyList = new ArrayList<>();
//
//        //第三步:定义Map用于存储所有请求参数的value
//        Map<String, String> keyValueMap = new HashMap<>();
//
//        //第四步:拿到所有具体请求参数
//        for (Map.Entry<String, String[]> paramsEntry : multiValueMap.entrySet()) {
//            String key = paramsEntry.getKey();
//            String[] values = paramsEntry.getValue();
//            for (Object value : values) {
//                if (!key.equals(REQUEST_SIGN) && value instanceof String) {
//
//                    //第五步:将请求参数的key添加到list中用于排序
//                    keyList.add(key);
//
//                    //第六步:将请求参数的value添加到Map中
//                    keyValueMap.put(key, (String) value);
//                }
//            }
//        }
//
//        //第七步:对请求参数key进行排序
//        Collections.sort(keyList);
//
//        StringBuilder paramsBuilder = new StringBuilder();
//
//        //第八步:依次取出排序之后的key-value,并拼接
//        for (String key : keyList) {
//            String value = keyValueMap.get(key);
//            paramsBuilder.append(key).append("=").append(value).append("&");
//        }
//
//        String params = "";
//        if(paramsBuilder.length() > 0) {
//            //去掉最后一个&
//            params = paramsBuilder.toString().substring(0, paramsBuilder.length() - 1);
//        }
//
//        //第九步:返回拼接好的参数
//        return params;
//    }
//}
