package com.hut.statics;

import com.hut.Calculator;

/**
 * 静态代理类
 */
public class StaticProxyCalculator implements Calculator {

    private Calculator calculator;

    /**
     * 使用构造函数传入目标
     * @param target
     */
    public StaticProxyCalculator(Calculator target) {
        this.calculator =  target;
    }

    @Override
    public int add(int i, int j) {
        // 非核心业务交给代理
        System.out.println("i = " + i + ", j = " + j);
        // 调用目标
        int result = calculator.add(1, 1);
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
