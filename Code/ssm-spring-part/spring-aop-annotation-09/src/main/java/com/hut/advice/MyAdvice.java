package com.hut.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * 定义4个增强方法，获取目标方法的信息 返回值 异常对象
 * 增强方法中，获取目标方法的信息
 *  1. 全部增强方法中，获取目标方法的信息(方法名，参数，访问修饰符，所属类的信息)
 *      (JoinPoint joinPoint) joinPoint包含目标方法的信息
 *  2. 返回的结果 @AfterReturning
 *      (Object result) result用于接收返回结果
 *      @AfterReturning(value = "execution(* com..impl.*.*(..))", returning = "形参名")
 *  3. 异常的信息 @AfterThrowing
 *      (Throwable throwable) throwable用于接收异常信息
 *      @AfterThrowing(value = "execution(* com..impl.*.*(..))",throwing = "形参名")
 */

@Aspect
@Component
public class MyAdvice {

    @Before("com.hut.pointcut.MyPointCut.myPc()")
    public void before(JoinPoint joinPoint) {
        // 1. 获取方法所属类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println("simpleName = " + simpleName);

        // 2. 获取方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("methodName = " + methodName);

        // 3. 获取方法参数
        Object[] args = joinPoint.getArgs();
        System.out.println("args = " + args);

        // 4. 获取访问修饰符
        int modifiers = joinPoint.getSignature().getModifiers();
        String s = Modifier.toString(modifiers);
        System.out.println("s = " + s);
    }

    @AfterReturning(value = "com.hut.pointcut.MyPointCut.myPc()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

    }

    @After("com.hut.pointcut.MyPointCut.myPc()")
    public void after(JoinPoint joinPoint) {

    }

    @AfterThrowing(value = "com.hut.pointcut.MyPointCut.myPc()",throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {

    }
}
