package com.forum.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResult {
    /**
     * 异常码
     */
    private Integer stats;

    /**
     * 异常信息
     */
    private String message;

    public static ErrorResult fail(Integer resultCode, String msg) {
        return new ErrorResult(resultCode, msg);
    }

    public static ErrorResult fail(ResultCode resultCode, String msg) {
        return new ErrorResult(resultCode.getCode(), msg);
    }


    public static ErrorResult fail(ResultCode resultCode) {
        return new ErrorResult(resultCode.getCode(), resultCode.getMsg());
    }

}
