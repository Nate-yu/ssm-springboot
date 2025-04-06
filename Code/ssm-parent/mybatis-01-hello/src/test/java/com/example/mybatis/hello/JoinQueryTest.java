package com.example.mybatis.hello;

import com.example.mybatis.hello.bean.Customer;
import com.example.mybatis.hello.bean.Order;
import com.example.mybatis.hello.mapper.CustomerMapper;
import com.example.mybatis.hello.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JoinQueryTest {
    
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CustomerMapper customerMapper;
    
    @Test
    void test01() {
        Order order = orderMapper.queryOrderWithCustomerById(1L);
        System.out.println("order = " + order);
    }

    @Test
    void test02() {
        Customer customer = customerMapper.getCustomerByIdWithOrders(1L);
        System.out.println("customer = " + customer);
    }

}
