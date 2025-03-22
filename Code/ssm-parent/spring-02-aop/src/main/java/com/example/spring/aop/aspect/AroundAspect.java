package com.example.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAspect {

    @Pointcut("execution(int com.example.spring.aop.calculator.MathCalculator.*(int, int))")
    public void pointCut() {}
    // 环绕通知
    /**
     * 环绕通知，需要在通知中定义目标方法的执行
     * @param joinPoint 目标方法（获取目标方法信息，多了一个执行方法）
     * @return 目标方法的返回值
     */
    @Around("pointCut()")
    public Object transaction(ProceedingJoinPoint joinPoint) throws Throwable{
        // 保证目标方法被执行
        Object[] args = joinPoint.getArgs(); // 获取目标方法的参数

        Object result = null;
        try {
            // 增强代码
            System.out.println("事务开始");
            result = joinPoint.proceed(args); // 执行目标方法
            System.out.println("事务结束");
        } catch (Throwable e) {
            System.out.println("事务回滚");
            // 必须再抛出异常
            throw new RuntimeException(e);
        } finally {
            System.out.println("释放资源");
        }
        return result;
    }
}
