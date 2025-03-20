package com.example.spring.aop.dynamic;

import com.example.spring.aop.log.LogUtils;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态代理
 */
public class DynamicProxy {
    public static Object getProxyInstance(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    String name = method.getName();
                    LogUtils.start(name,args);
                    Object result = null;
                    try {
                        result = method.invoke(target, args);
                        LogUtils.logReturn(name,result);
                    } catch (Exception e) {
                        LogUtils.exception(name,e);
                    } finally {
                        LogUtils.end(name);
                    }
                    return result;
        });
    }
}
