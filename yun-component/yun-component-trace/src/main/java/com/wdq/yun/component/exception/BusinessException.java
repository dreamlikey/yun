package com.wdq.yun.component.exception;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;

/**
 * @author wudq
 * @date 2019/8/21
 * @Description: TODO
 */
@Data
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    private String message;

    private int errCode;

    public BusinessException(int errCode, String message) {
        this.errCode = errCode;
        this.message = message;
        this.message = toJsonMessage();
    }

    public String toJsonMessage() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message",this.message);
        jsonObject.put("errCode",this.errCode);
        return jsonObject.toString();
    }
}
