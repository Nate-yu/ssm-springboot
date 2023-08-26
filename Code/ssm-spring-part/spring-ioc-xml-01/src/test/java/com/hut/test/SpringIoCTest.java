package com.hut.test;

import com.hut.ioc_03.HappyComponent;
import com.hut.ioc_04.JavaBean2;
import com.hut.ioc_05.JavaBean;
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

    /**
     * 测试ioc配置和销毁方法的触发
     */
    @Test
    public void test_04() {
        // 1. 创建ioc容器，就会进行组件对象的实例化 -> init
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-04.xml");

        // 单例与多例的测试
        JavaBean2 bean = classPathXmlApplicationContext.getBean(JavaBean2.class);
        JavaBean2 bean1 = classPathXmlApplicationContext.getBean(JavaBean2.class);
        System.out.println(bean == bean1);

        // 2. 正常结束ioc容器
        classPathXmlApplicationContext.close();
    }

    /**
     * 读取使用factoryBean工厂配置的组件对象
     */
    @Test
    public void test_05() {
        // 1. 创建ioc容器，就会进行组件对象的实例化 -> init
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-05.xml");

        // 2. 读取组件
        JavaBean javaBean = classPathXmlApplicationContext.getBean("javaBean", JavaBean.class);
        System.out.println("javaBean = " + javaBean);
        //FactoryBean工厂也会加入到ioc容器：&id，但不会被实例化
        Object javaBean1 = classPathXmlApplicationContext.getBean("&javaBean");
        System.out.println("javaBean1 = " + javaBean1);

        // 3. 正常结束ioc容器
        classPathXmlApplicationContext.close();
    }
}
