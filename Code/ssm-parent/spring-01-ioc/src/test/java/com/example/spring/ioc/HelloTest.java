package com.example.spring.ioc;

import com.example.spring.ioc.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
public class HelloTest {
    @Autowired
    User user;

    @Test
    public void test01() {
        System.out.println("user = " + user);
        Assertions.assertNotNull(user, "User should not be null");
        Assertions.assertNull(user.getUsername(), "Username should be null");
        Assertions.assertNull(user.getPassword(), "Password should be null");
    }
}
