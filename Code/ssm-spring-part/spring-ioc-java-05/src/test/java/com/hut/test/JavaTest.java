package com.hut.test;

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
}
