package com.hut.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.hut")
@EnableAspectJAutoProxy // 开启aspectj注解的支持
public class JavaConfig {
}
