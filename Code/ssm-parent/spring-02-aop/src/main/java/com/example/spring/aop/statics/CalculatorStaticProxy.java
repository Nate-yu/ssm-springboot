package com.example.spring.aop.statics;

import com.example.spring.aop.calculator.MathCalculator;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CalculatorStaticProxy implements MathCalculator{
    private MathCalculator target; // 目标对象
    public CalculatorStaticProxy(MathCalculator mathCalculator) {
        this.target = mathCalculator;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int add = target.add(i, j);
        System.out.println("i+j = " + add);
        return add;

    }

    @Override
    public int subtract(int i, int j) {
        return target.subtract(i, j);
    }

    @Override
    public int multiply(int i, int j) {
        return target.multiply(i, j);
    }

    @Override
    public int divide(int i, int j) {
        return target.divide(i, j);
    }
}
