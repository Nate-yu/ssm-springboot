package com.hut.ioc_04;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class JavaBean {
    @Value("张三") // 注解赋值，主要用于读取外部配置
    private String name;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.age:19}")
    private int age;
}
