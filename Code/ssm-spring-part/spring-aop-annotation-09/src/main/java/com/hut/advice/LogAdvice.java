package com.hut.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 增强类的内部要存储增强代码
 * 1. 定义方法存储增强代码
 *  具体定义几个方法是根据插入位置决定的
 * 2. 使用注解配置来指定目标方法的位置（前置@Before 后置@AfterReturning 异常@AfterThrowing 最后@After 环绕@Around）
 * 3. 配置切点表达式
 * 4. 补全注解
 *  加入ioc容器 @Component
 *  配置切面 @Aspect = 切点 + 增强
 * 5. 开启aspect注解的支持
 */
@Aspect
@Component
public class LogAdvice {

    @Before("execution(* com.hut.service.impl.*.*(..))")
    public void start() {
        System.out.println("方法开始了");
    }

    @After("execution(* com.hut.service.impl.*.*(..))")
    public void after() {
        System.out.println("方法结束了");
    }

    @AfterThrowing("execution(* com.hut.service.impl.*.*(..))")
    public void error() {
        System.out.println("方法报错了");
    }
}
