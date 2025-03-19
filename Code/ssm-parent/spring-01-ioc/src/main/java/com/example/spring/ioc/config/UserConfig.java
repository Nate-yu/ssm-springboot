package com.example.spring.ioc.config;

import com.example.spring.ioc.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean(initMethod = "initUser", destroyMethod = "destroyUser")
    public User user(){
        return new User();
    }
}
