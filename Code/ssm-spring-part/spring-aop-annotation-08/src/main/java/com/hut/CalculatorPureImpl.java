package com.hut;


/**
 * 实现计算接口,单纯添加 + - * / 实现
 */
public class CalculatorPureImpl implements Calculator {
    
    @Override
    public int add(int i, int j) {

        int result = i + j;

        return result;
    }
    
    @Override
    public int sub(int i, int j) {

        int result = i - j;

        return result;
    }
    
    @Override
    public int mul(int i, int j) {
    
        int result = i * j;
    
        return result;
    }
    
    @Override
    public int div(int i, int j) {
    
        int result = i / j;
    
        return result;
    }
}