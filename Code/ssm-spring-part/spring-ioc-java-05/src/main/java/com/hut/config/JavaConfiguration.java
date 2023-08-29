package com.hut.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * java配置类，替代xml配置文件
 * 1. 包扫描注解配置
 * 2. 引用外部的配置文件
 * 3. 声明第三方依赖的bean组件
 */
@Configuration
@ComponentScan("com.hut.ioc_01")
@PropertySource("classpath:jdbc.properties")
public class JavaConfiguration {
}
