package com.hut.test;

import com.hut.ioc_03.HappyComponent;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * ioc容器创建和读取组件的测试类
 */
public class SpringIoCTest {
    /**
     * 创建IoC容器并读取配置文件
     */
    public void createIoC() {
        // 创建容器，选择合适的容器
        // 方式1：直接创建容器并且指定配置文件
        // 构造函数(String...配置文件) 可以填写一个或者多个
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        // 方式2：先创建ioc容器对象，再指定配置文件，最后刷新（源码的配置过程）
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        classPathXmlApplicationContext.setConfigLocation("spring-03.xml"); // 外部配置文件的设置
        classPathXmlApplicationContext.refresh(); // 调用ioc和di的流程
    }

    /**
     * 在IoC容器中获取组件Bean
     */
    @Test
    public void getBeanFromIoC() {
        // 1. 创建ioc容器对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("spring-03.xml");
        applicationContext.refresh();

        // 2. 读取ioc容器的组件
        // 方案1：直接根据beanId获取（返回类型是Object，需要强转，故不推荐）
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");

        // 方案2：根据beanId，同时指定bean的类型 Class
        HappyComponent happyComponent1 = applicationContext.getBean("happyComponent", HappyComponent.class);

        // 方案3：直接根据类型获取
        // 根据bean的类型和获取，同一个类型，在ioc容器中只能有一个bean
        // ioc的配置一定是实现类，但也可以根据接口类型获取值
        HappyComponent happyComponent2 = applicationContext.getBean(HappyComponent.class);

        happyComponent2.doWork();

        System.out.println(happyComponent == happyComponent1);
        System.out.println(happyComponent2 == happyComponent1);
    }
}