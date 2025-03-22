package com.example.spring.aop;

import com.example.spring.aop.calculator.MathCalculator;
import com.example.spring.aop.calculator.impl.MathCalculatorImpl;
import com.example.spring.aop.proxy.dynamic.DynamicProxy;
import com.example.spring.aop.proxy.statics.CalculatorStaticProxy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SpringBootTest
public class MathTest {

    @Test
    void test03(){
        MathCalculator proxyInstance = (MathCalculator) DynamicProxy.getProxyInstance(new MathCalculatorImpl());
        proxyInstance.add(1,2);
        System.out.println("=========================");
        proxyInstance.divide(1,0);
    }

    @Test
    void test02(){
        MathCalculatorImpl target = new MathCalculatorImpl();
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             *
             * @param proxy 代理对象
             * @param method 代理对象准备调用目标对象的方法
             * @param args 方法调用传递的参数
             * @return 返回目标对象的方法调用结果
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("InvocationHandler的invoke在运行。。。");
                return method.invoke(target, args);
            }
        };
        // 创建动态代理

        /**
         * ClassLoader:目标对象的类加载器
         * Interface[]:目标对象实现的接口的类型
         * InvocationHandler:执行目标对象方法时，会触发事件处理器的方法，会把当前执行目标对象的方法作为一个参数传入
         */
        MathCalculator proxyInstance = (MathCalculator) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                invocationHandler);
        int add = proxyInstance.add(1, 2);
        System.out.println("add = " + add);
    }

    @Test
    void test01(){
        MathCalculatorImpl target = new MathCalculatorImpl();
        // 创建静态代理对象
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(target);
        int add = proxy.add(1, 2);
    }
}
