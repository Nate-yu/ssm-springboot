package com.example.mybatis.hello;

import com.example.mybatis.hello.bean.User;
import com.example.mybatis.hello.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatis01HelloApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void testEmpMapper() {
        /*User user = userMapper.selectUserById(1);
        System.out.println("user = " + user);*/

        /*User user = new User();
        user.setId(5);
        user.setUserName("李四");
        user.setAge(28);
        user.setUserSalary(10300.0);*/
//        userMapper.saveUser(user);
//        Integer id = user.getId();
//        System.out.println("id = " + id);
//        userMapper.updateUser(user);
        List<User> allUsers = userMapper.getAll();
        for(User user : allUsers) {
            System.out.println("user = " + user);
        }
    }

    @Test
    void contextLoads() {
    }

}
