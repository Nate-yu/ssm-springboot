package com.example.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class AccountDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 按照username扣减账户余额
    public void updateAccountBalance(String username, BigDecimal money) {
        String sql = "update account set balance = balance - ? where username = ?";
        jdbcTemplate.update(sql, money, username);
    }
}
