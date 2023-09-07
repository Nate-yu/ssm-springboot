package com.hut.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 用于存储切点的类
 */
@Component
public class MyPointCut {
    @Pointcut("execution(* com.hut.service.impl.*.*(..))")
    public void pc() {}

    @Pointcut("execution(* com..impl.*.*(..))")
    public void myPc(){}
}
