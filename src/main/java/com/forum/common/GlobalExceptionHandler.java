package com.forum.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     *系统异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResult handlerThrowable(Throwable e, HttpServletRequest request) {
        // 系统异常
        log.error("发生系统异常{}", e);
        return ErrorResult.fail(ResultCode.SYSTEM_ERROR);
    }

    /**
     * 自定义异常
     */

    @ExceptionHandler(BusisnessException.class)
    public ErrorResult handlerBusisnessException(BusisnessException e, HttpServletRequest request) {
        log.error("发生业务异常{}", e.getMessage());
        return ErrorResult.fail(e.getCode(), e.getMessage());
    }

    /**
     * validation 统一异常处理
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResult handlerValidationException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("发生参数校验异常{}", e.getMessage());
        StringBuilder msg = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach(errMsg -> {
            msg.append(errMsg.getDefaultMessage() + ",");
        });
        // 删除最后一个字符
        msg.deleteCharAt(msg.length()-1);
        return ErrorResult.fail(200012, msg.toString());
    }
}
