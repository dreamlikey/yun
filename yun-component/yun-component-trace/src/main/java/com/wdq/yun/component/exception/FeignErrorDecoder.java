package com.wdq.yun.component.exception;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import org.springframework.context.annotation.Configuration;

import java.io.*;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

/**
 * @author wudq
 * @date 2019/8/21
 * @Description: 自定义异常重写FeignException
 */
@Configuration
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        BaseException baseException = new BaseException();
        String feignMessage = null;
        try {
            // 这里直接拿到我们抛出的异常信息
            feignMessage = Util.toString(response.body().asReader());
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = JSONObject.parseObject(feignMessage);
        //自定义异常
        String customMessage = jsonObject.getString("message");

        baseException.setMsg(customMessage);
        baseException.setCode(jsonObject.getInteger("status"));
        JSONObject customJsonObj = null;
        try {
            customJsonObj = JSONObject.parseObject(customMessage);
            baseException.setMsg(customJsonObj.getString("message"));
            baseException.setCode(customJsonObj.getInteger("errCode"));
        } catch (Exception e) {
        }
        baseException.setPath(jsonObject.getString("path"));

        return baseException;
    }
}
