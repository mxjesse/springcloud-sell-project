package com.mx.sellobjorder.exception;

/**
 * @author mx
 * @date 2019/5/10 2:17 PM
 */
public class OrderException extends RuntimeException {

    private Integer code;

    private String msg;

    public OrderException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
