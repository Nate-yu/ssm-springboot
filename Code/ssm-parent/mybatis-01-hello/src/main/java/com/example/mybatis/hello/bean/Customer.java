package com.example.mybatis.hello.bean;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private Integer id;
    private String customerName;
    private String phone;

    // 保存所有订单
    private List<Order> orders;
}
