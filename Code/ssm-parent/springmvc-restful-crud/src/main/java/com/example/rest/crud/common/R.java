package com.example.rest.crud.common;

import lombok.Data;

// 通用返回结果类
@Data
public class R<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> R<T> success(T data) {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMessage("success");
        r.setData(data);
        return r;
    }

    public static <T> R<T> success() {
        R r = new R<>();
        r.setCode(200);
        r.setMessage("success");
        return r;
    }

    public static R error(String message) {
        R r = new R<>();
        r.setCode(500);
        r.setMessage(message);
        return r;
    }

    public static R error(Integer code, String message) {
        R r = new R<>();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public static R error(Integer code, String message, Object data) {
        R r = new R<>();
        r.setCode(code);
        r.setMessage(message);
        r.setData(data);
        return r;
    }
}
