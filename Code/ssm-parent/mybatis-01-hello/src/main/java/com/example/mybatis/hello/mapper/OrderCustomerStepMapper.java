package com.example.mybatis.hello.mapper;

import com.example.mybatis.hello.bean.Customer;
import com.example.mybatis.hello.bean.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderCustomerStepMapper {
    // 分布查询
    Customer getCustomerById(Long id);
    List<Order> getOrdersByCustomerId(Long cId);

    // 分布查询，根据id查询客户及其订单
    Customer getCustomerByIdAndOrderStep(Long id);

    // 分布查询，根据id查询订单及其客户
    Order getOrderByIdAndCustomerStep(Long id);
}
