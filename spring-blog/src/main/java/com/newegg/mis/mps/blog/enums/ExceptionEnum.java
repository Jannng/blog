package com.newegg.mis.mps.blog.enums;

/**
 * Created by jt1n on 2019/8/9.
 */
public enum ExceptionEnum {
    FAIL_CREATE(-1, "创建失败"),
    LOGIN_WRONG(-2, "用户名或者密码错误");

    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String msg;

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
