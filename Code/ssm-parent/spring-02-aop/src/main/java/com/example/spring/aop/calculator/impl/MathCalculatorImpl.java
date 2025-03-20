package com.example.spring.aop.calculator.impl;

import com.example.spring.aop.calculator.MathCalculator;
import org.springframework.stereotype.Component;

@Component
public class MathCalculatorImpl implements MathCalculator {
    @Override
    public int add(int i, int j) {
        return i+j;
    }

    @Override
    public int subtract(int i, int j) {
        return i-j;
    }

    @Override
    public int multiply(int i, int j) {
        return i*j;
    }

    @Override
    public int divide(int i, int j) {
        return i/j;
    }
}
