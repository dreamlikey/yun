package com.wdq.yun.component.exception;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author wudq
 * @date 2019/8/21
 * @Description:
 */
public class ExceptionEntity {
    private static final long serialVersionUID = 1L;

    private String message;

    private int    code;

    private String error;

    private String path;

    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date timestamp = new Date();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
