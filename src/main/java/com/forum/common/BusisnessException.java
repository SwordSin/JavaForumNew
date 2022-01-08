package com.forum.common;

import lombok.Data;

@Data
public class BusisnessException extends RuntimeException{
    protected Integer code;
    protected String message;

    public BusisnessException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
    }

    public BusisnessException(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }


}
