package com.example.mybatis.hello;

import com.example.mybatis.hello.bean.User;
import com.example.mybatis.hello.mapper.UserDynamicSQLMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DynamicSQLTest {
    @Autowired
    UserDynamicSQLMapper userDynamicSQLMapper;
    @Test
    public void test01() {
        userDynamicSQLMapper.selectUserByUserNameAndUserSalary("zhangsan", null);
    }

    @Test
    public void test02() {
        User user = new User();
        user.setId(3);
        user.setUserSalary(1000.0);
        userDynamicSQLMapper.updateUser(user);
    }
}
