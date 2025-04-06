package com.example.mybatis.hello.mapper;

import com.example.mybatis.hello.bean.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    // 通过id查询客户及其所有订单
    Customer getCustomerByIdWithOrders(Long id);

}
