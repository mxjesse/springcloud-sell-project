package com.mx.product.exception;

import com.mx.product.enums.ResultEnum;

/**
 * @author mx
 * @date 2019/5/20 4:42 PM
 */
public class ProductException extends RuntimeException {

    private String msg;

    private Integer code;

    public ProductException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        this(resultEnum.getMsg(), resultEnum.getCode());
    }
}
