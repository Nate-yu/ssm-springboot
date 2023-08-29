package com.hut.test;

import com.hut.components.A;
import com.hut.components.B;
import com.hut.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {JavaConfig.class})
public class JavaTest {
    @Autowired
    private A a;
    @Autowired
    private B b;
    @Test
    public void test() {
        System.out.println(a);
        System.out.println(b);
    }
}
