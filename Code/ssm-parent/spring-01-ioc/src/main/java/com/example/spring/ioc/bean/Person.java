package com.example.spring.ioc.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Person {
    @Value("阿彬")
    private String name;
    @Value("${person.age}")
    private int age;
    @Value("男")
    private String gender;
    /**
     * 1. @Value("字面值")：直接赋值
     * 2. @Value("${key}")：从配置文件中获取值
     * 3. @Value("#{bean.属性}")：Spring表达式语言，从容器中获取值
     */
}
