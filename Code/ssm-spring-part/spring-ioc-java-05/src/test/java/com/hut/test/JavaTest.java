package com.hut.test;

import com.hut.config.ConfigA;
import com.hut.config.ConfigB;
import com.hut.config.JavaConfiguration;
import com.hut.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        StudentController controller = applicationContext.getBean(StudentController.class);
        System.out.println("controller = " + controller);
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigA.class);
        ConfigA beanA = applicationContext.getBean(ConfigA.class);
        ConfigB beanB = applicationContext.getBean(ConfigB.class);
        System.out.println("beanA = " + beanA);
        System.out.println("beanB = " + beanB);
    }
}
