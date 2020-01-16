package com.rabbitmq.springboot.common;


/**
 * @author Rison_Lee on 2020/1/16 10:39.
 * @version 1.0
 */
public enum StatusCode {

    Success(0,"成功"),
    Fail(-1,"失败");

    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
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
