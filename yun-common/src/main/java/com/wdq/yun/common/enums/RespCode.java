package com.wdq.yun.common.enums;

/**
 * @author wudq
 * @date 2019/8/21
 * @Description:
 */
public enum RespCode {
    PASS_OK(0,"操作成功");
    private int code;
    private String desc;

    RespCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
