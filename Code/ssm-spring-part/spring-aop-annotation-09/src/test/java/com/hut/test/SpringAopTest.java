package com.hut.test;

import com.hut.config.JavaConfig;
import com.hut.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {

    // 这里只能用接口来声明对象，不能用实现类
    @Autowired
    private Calculator calculator;

    @Test
    public void test(){
        int add = calculator.add(1, 1);
        System.out.println("add = " + add);
    }
}
