package com.mx.userserver.enums;

/**
 * @author mx
 * @date 2019/5/22 1:59 PM
 */
public enum ResultEnum {

    LOGIN_FAIL(0, "登录失败"),
    ROLE_ERROR(1, "角色错误"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
