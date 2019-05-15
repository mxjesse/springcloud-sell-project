package com.mx.sellobjorder.enums;

/**
 * @author mx
 * @date 2019/5/9 5:42 PM
 */
public enum OrderStatusEnum {

    NEW(0, "新订单"),
    FINISHED(1, "已完成"),
    CANCELED(2, "已取消");

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
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
