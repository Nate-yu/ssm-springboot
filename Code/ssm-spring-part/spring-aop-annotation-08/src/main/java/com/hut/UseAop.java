package com.hut;

import com.hut.dyn.ProxyFactory;
import com.hut.statics.StaticProxyCalculator;

public class UseAop {
    public static void main(String[] args) {
        Calculator target = new CalculatorPureImpl();
        Calculator proxy = new StaticProxyCalculator(target);
        int add = proxy.add(1, 1);
        System.out.println("add = " + add);

        // jdk代理
        ProxyFactory factory = new ProxyFactory(target);
        // 使用接口接值
        Calculator proxy1 = (Calculator) factory.getProxy();
        proxy1.add(1,1);

    }
}
