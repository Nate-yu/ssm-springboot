package com.example.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect // 声明这是一个切面
public class LogAspect {

    @Pointcut("execution(int com.example.spring.aop.calculator.MathCalculator.*(int, int))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取方法名
        String name = signature.getName();
        // 获取方法参数
        Object[] args = joinPoint.getArgs();
        System.out.println("AoP Start--name = " + name + " args = " + Arrays.toString(args));
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("AoP End--name = " + name);
    }

    @AfterThrowing(value = "pointCut()",
            throwing = "e") // throwing指定异常
    public void logException(JoinPoint joinPoint, Throwable e) {
        String name = joinPoint.getSignature().getName();
        System.out.println("AoP Exception--name = " + name + " Exception = " + e);
    }

    @AfterReturning(value = "pointCut()",
            returning = "result") // returning指定返回值
    public void logReturn(JoinPoint joinPoint, Object result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("AoP Return--name = " + name + " result = " + result);
    }
}
