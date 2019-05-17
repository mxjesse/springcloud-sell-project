package com.mx.sellobjorder.enums;

/**
 * @author mx
 * @date 2019/5/10 1:37 PM
 */
public enum ResultEnum {

    PARAM_ERROR(0, "参数错误"),
    CART_EMPTY(1, "购物车为空"),
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
