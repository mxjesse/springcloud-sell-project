package com.mx.userserver.vo;

/**
 * @author mx
 * @date 2019/5/8 1:04 AM
 */
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
