package com.forum.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer status;
    private String desc;
    private Object data;

    // 成功
    public static Result suc() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS_NULL);
        return result;
    }

    public static Result suc(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    // 成功
    public static Result suc(Integer code, String desc) {
        Result result = new Result();
        result.setStatus(code);
        result.setDesc(desc);
        return result;
    }

    // 失败
    public static Result fail(Integer code, String desc) {
        Result result = new Result();
        result.setStatus(code);
        result.setDesc(desc);
        return result;
    }

    public static Result fail(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    private void setResultCode(ResultCode resultCode) {
        this.status = resultCode.getCode();
        this.desc = resultCode.getMsg();
    }
}
