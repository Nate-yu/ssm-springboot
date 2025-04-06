package com.example.mybatis.hello;

import com.example.mybatis.hello.bean.Customer;
import com.example.mybatis.hello.bean.Order;
import com.example.mybatis.hello.mapper.CustomerMapper;
import com.example.mybatis.hello.mapper.OrderCustomerStepMapper;
import com.example.mybatis.hello.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JoinQueryTest {
    
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private OrderCustomerStepMapper orderCustomerStepMapper;
    
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

    // 原生分布查询
    @Test
    void testStep01() {
        Customer customer = orderCustomerStepMapper.getCustomerById(1L);
        List<Order> orders = orderCustomerStepMapper.getOrdersByCustomerId(customer.getId());
        customer.setOrders(orders);
        System.out.println("customer = " + customer);
    }

    @Test
    void testStep02() {
        Customer customer = orderCustomerStepMapper.getCustomerByIdAndOrderStep(1L);
        System.out.println("customer = " + customer);
    }

    @Test
    void testStep03() {
        Order order = orderCustomerStepMapper.getOrderByIdAndCustomerStep(1L);
        System.out.println("order = " + order);
    }

}
