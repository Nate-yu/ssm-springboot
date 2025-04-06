package com.example.mybatis.hello.mapper;

import com.example.mybatis.hello.bean.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    // 按照id查询订单以及下单的客户
    public Order queryOrderWithCustomerById(Long id);
}
