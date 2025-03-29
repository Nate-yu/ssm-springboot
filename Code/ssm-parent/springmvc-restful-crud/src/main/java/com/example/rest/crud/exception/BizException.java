package com.example.rest.crud.exception;

import lombok.Data;

/**
 * 业务异常
 */
@Data
public class BizException extends RuntimeException{
    private Integer code;
    private String msg;
    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(BizExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }
}
