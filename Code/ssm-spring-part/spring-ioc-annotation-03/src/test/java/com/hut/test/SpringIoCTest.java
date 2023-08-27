package com.hut.test;

import com.hut.ioc_01.XxxDao;
import com.hut.ioc_02.JavaBean;
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

    @Test
    public void testIoC_02() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        JavaBean bean = applicationContext.getBean(JavaBean.class);
        JavaBean bean1 = applicationContext.getBean(JavaBean.class);
        System.out.println(bean == bean1);
        applicationContext.close();
    }
}
