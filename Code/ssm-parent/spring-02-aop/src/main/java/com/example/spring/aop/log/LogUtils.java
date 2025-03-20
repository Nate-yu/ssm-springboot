package com.example.spring.aop.log;

import java.util.Arrays;

public class LogUtils {
    public static void start(String name, Object... args){
        System.out.println("日志记录开始：" + name + " 参数：" + Arrays.toString(args));
    }

    public static void end(String name){
        System.out.println("日志记录结束：" + name);
    }

    public static void exception(String name, Exception message){
        System.out.println("日志记录异常：" + name + " 异常信息：" + message.getCause());
    }

    public static void logReturn(String name, Object result){
        System.out.println("日志记录返回：" + name + " 返回值：" + result);
    }
}
