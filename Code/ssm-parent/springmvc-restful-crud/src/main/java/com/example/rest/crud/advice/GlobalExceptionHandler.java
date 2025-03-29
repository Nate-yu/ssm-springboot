package com.example.rest.crud.advice;

import com.example.rest.crud.common.R;
import com.example.rest.crud.exception.BizException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局异常处理器
//@ResponseBody
//@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R error(Exception e) {
        System.out.println("Exception全局异常处理器捕获异常：");
        return R.error(500, e.getMessage());
    }

    @ExceptionHandler(ArithmeticException.class)
    public R error(ArithmeticException e) {
        System.out.println("ArithmeticException全局异常处理器捕获异常");
        return R.error(500, e.getMessage());
    }

    @ExceptionHandler(BizException.class)
    public R error(BizException e) {
        Integer code = e.getCode();
        String msg = e.getMsg();
        return R.error(code, msg);
    }
}
