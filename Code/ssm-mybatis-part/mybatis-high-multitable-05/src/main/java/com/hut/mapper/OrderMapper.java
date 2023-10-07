package com.hut.mapper;

import com.hut.pojo.Order;

public interface OrderMapper {
    // 根据id查询订单信息和订单对应的客户
    Order queryOrderById(Integer id);
}
