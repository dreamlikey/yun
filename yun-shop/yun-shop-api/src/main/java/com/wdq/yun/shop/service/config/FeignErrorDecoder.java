//package com.wdq.yun.shop.service.config;
//
//import com.alibaba.fastjson.JSONObject;
//import com.wdq.yun.component.exception.BaseException;
//
//import org.springframework.context.annotation.Configuration;
//
//import java.io.*;
//
//import feign.Response;
//import feign.Util;
//import feign.codec.ErrorDecoder;
//
///**
// * @author wudq
// * @date 2019/8/21
// * @Description: 自定义异常重写FeignException
// */
//@Configuration
//public class FeignErrorDecoder implements ErrorDecoder {
//    @Override
//    public Exception decode(String s, Response response) {
//        BaseException baseException = new BaseException();
//        try {
//            // 这里直接拿到我们抛出的异常信息
//            String feignMessage = Util.toString(response.body().asReader());
//
//            JSONObject jsonObject = JSONObject.parseObject(feignMessage);
//            //自定义异常
//            String customMessage = jsonObject.getString("message");
//            JSONObject customJsonObj = JSONObject.parseObject(customMessage);
//
//            baseException.setMsg(customJsonObj.getString("message"));
//            baseException.setCode(customJsonObj.getInteger("errCode"));
//            baseException.setPath(jsonObject.getString("path"));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return baseException;
//    }
//}
