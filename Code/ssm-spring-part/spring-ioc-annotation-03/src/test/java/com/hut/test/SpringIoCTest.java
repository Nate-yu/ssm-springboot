package com.hut.test;

import com.hut.ioc_01.XxxDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * springioc测试
 */
public class SpringIoCTest {
    @Test
    public void testIoC_01() {
        // 1. 创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        // 2. 获取组件
        XxxDao dao = applicationContext.getBean(XxxDao.class);
        System.out.println("dao = " + dao);

        // 添加ioc注解，默认的组件名为类的首字母小写
        Object service = applicationContext.getBean("xxxService");
        System.out.println("service = " + service);

        // 3. 关闭容器
        applicationContext.close();
    }
}
