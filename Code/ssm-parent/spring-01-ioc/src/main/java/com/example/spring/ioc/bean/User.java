package com.example.spring.ioc.bean;

import lombok.Data;

/**
 * 用于测试生命周期
 */
@Data
public class User {
    private String username;
    private String password;

    // 默认构造方法
    public User(){
        System.out.println("User constructor...");
    }

    // 初始化方法
    public void initUser(){
        System.out.println("User init...");
    }

    // 销毁方法
    public void destroyUser(){
        System.out.println("User destroy...");
    }
}
