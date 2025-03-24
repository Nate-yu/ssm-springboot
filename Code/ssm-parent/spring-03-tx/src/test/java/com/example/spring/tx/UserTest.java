package com.example.spring.tx;

import com.example.spring.tx.dao.AccountDAO;
import com.example.spring.tx.dao.BookDAO;
import com.example.spring.tx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootTest
public class UserTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserService userService;
    @Test
    public void testCheckout() {
        userService.checkout("zhangsan", 1, 3);
    }
}
