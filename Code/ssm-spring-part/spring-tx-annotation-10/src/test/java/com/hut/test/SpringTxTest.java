package com.hut.test;

import com.hut.config.JavaConfig;
import com.hut.service.StudentService;
import com.hut.service.TopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(JavaConfig.class)
public class SpringTxTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TopService topService;

    @Test
    public void test() {
        topService.topService();
    }
}
