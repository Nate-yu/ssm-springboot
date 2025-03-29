package com.example.rest.crud.exception;

import lombok.Getter;

public enum BizExceptionEnum {
    ORDER_CLOSED(10001, "订单已关闭"),
    ORDER_NOT_EXIST(10002, "订单不存在"),
    ORDER_NOT_PAY(10003, "订单未支付"),

    PRODUCT_NOT_EXIST(20001, "商品不存在"),
    PRODUCT_NOT_ENOUGH(20002, "商品库存不足"),
    PRODUCT_NOT_ON_SALE(20003, "商品已下架");

    @Getter
    private Integer code;
    @Getter
    private String msg;

    BizExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
