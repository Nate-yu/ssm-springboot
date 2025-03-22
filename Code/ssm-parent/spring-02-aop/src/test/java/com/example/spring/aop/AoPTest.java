package com.example.spring.aop;

import com.example.spring.aop.calculator.MathCalculator;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AoPTest {
    /**
     * Aop 的底层原理：
     * 1. Spring会为每个被切面切入的组件创建代理对象
     * 2. 在代理对象中，会创建一个拦截器链，拦截器链中保存了所有通知方法
     * 3. 当调用被切入的方法时，会通过代理对象调用被切入的方法，同时会调用拦截器链中的通知方法
     * 4. 通知方法执行完毕后，才会执行被切入的方法
     * 5. 通知方法执行完毕后，会返回被切入的方法的返回值
     */

    @Resource(name = "mathCalculatorImpl")
    MathCalculator calculator;
    @Test
    void test() {

        System.out.println("calculator = " + calculator);
        System.out.println(calculator.divide(1, 0));
    }
}
