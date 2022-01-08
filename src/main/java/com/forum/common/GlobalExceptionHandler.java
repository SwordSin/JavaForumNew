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
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // HTTP 状态码
    @ExceptionHandler(Throwable.class)
    public ErrorResult handlerThrowable(Throwable e, HttpServletRequest request) {
        // 系统异常
        log.error("发生系统异常{}", e);
        return ErrorResult.fail(ResultCode.SYSTEM_ERROR);
    }

    /**
     * 自定义异常
     */
//    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(BusisnessException.class)
    public ErrorResult handlerBusisnessException(BusisnessException e, HttpServletRequest request) {
        log.error("发生业务异常{}", e.getMessage());
        return ErrorResult.fail(e.getCode(), e.getMessage());
    }

    /**
     * validation 参数校验异常
     */
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
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

    /**
     * Assert 异常处理
     */
//    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult handlerAccessException(IllegalArgumentException e, HttpServletRequest request) {
        log.error("参数格式正确,但是该参数可能是无效参数, {}", e.getMessage());
        return ErrorResult.fail(200012, e.getMessage());
    }
}
