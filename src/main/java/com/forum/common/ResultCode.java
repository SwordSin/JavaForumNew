package com.forum.common;

public enum ResultCode {
    SUCCESS_NULL(0, "成功, 但是结果位null"),
    SUCCESS(1, "成功"),
    // 系统异常
    SYSTEM_ERROR(10000, "系统异常,请求稍后重试"),
    // 业务异常
    PARAM_IS_INVALID(20001, "参数无效"),
    USER_HAS_EXISTED(20002,"用户名已存在"),
    USER_NOT_FIND(20003,"用户名不存在");

    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
