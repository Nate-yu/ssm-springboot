package com.hut.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 事务增强
 */
@Component
@Aspect
@Order(10) // 指定一个优先级的值，值越小优先级越高
public class TxAdvice {
    @Before("com.hut.pointcut.MyPointCut.pc()")
    public void before(){
        System.out.println("事务开始");
    }

    @AfterReturning("com.hut.pointcut.MyPointCut.pc()")
    public void commit() {
        System.out.println("事务提交");
    }

    @AfterThrowing("com.hut.pointcut.MyPointCut.pc()")
    public void rollback() {
        System.out.println("事务回滚");
    }


}
