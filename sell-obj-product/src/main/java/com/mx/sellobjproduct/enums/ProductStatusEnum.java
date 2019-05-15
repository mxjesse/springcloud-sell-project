package com.mx.sellobjproduct.enums;

/**
 * @author mx
 * @date 2019/5/8 1:00 AM
 */
public enum ProductStatusEnum {

    UP(1, "上架"),
    DOWN(0, "下架");

    private Integer code;

    private String msg;

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

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
