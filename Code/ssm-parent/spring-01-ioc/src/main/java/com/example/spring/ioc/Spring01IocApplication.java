package com.example.spring.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序，主入口类
 */
@SpringBootApplication
public class Spring01IocApplication {

    public static void main(String[] args) {
        /*// 启动Spring应用，返回IOC容器 ApplicationContext: IOC容器
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("ioc: " + ioc);
        System.out.println("===============================");
        // 获取容器中所有组件的名字
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }*/
        SpringApplication.run(Spring01IocApplication.class, args);
    }

}
