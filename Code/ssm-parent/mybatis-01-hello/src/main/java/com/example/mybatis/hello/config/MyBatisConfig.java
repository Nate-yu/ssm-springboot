package com.example.mybatis.hello.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MyBatisConfig {

    @Bean
    PageInterceptor pageInterceptor() {
        // 创建分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();
        // 添加配置
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
