package com.example.mybatis.hello.bean;

import lombok.Data;
import lombok.ToString;

@Data
public class Order {
    private Integer id;
    private String address;
    private Double amount;
    private Integer customerId;

    // 订单对应的客户
    private Customer customer;
}
