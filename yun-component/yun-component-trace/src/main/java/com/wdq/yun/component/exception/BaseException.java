package com.wdq.yun.component.exception;

import com.wdq.yun.common.enums.RespCode;

import lombok.Data;

/**
 * @author wudq
 * @date 2019/8/21
 * @Description:
 */
@Data
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private String path;


    public BaseException() {
        this.code = RespCode.PASS_OK.getCode();
        this.msg = RespCode.PASS_OK.getDesc();
    }

    public BaseException(int errCode, String message) {
        super();
        this.code = errCode;
        this.msg = message;
    }

}
