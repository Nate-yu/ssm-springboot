package com.hut.test;

import com.hut.mapper.UserMapper;
import com.hut.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MyBatisTest {

    private SqlSession session;

    private UserMapper mapper;

    // junit5会在每一个@Test方法前执行@BeforeEach方法
    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);
        mapper = session.getMapper(UserMapper.class);
    }

    // junit5会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.close();
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("yubin");
        user.setPassword("11111");
        int rows = mapper.insert(user);
        System.out.println("rows = " + rows);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(2);
        user.setUsername("nate");
        user.setPassword("11111");
        int rows = mapper.update(user);
        System.out.println("rows = " + rows);
    }

    @Test
    public void testDelete() {
        int rows = mapper.delete(2);
        System.out.println("rows = " + rows);
    }

    @Test
    public void testSelectById() {
        User user = mapper.selectById(1);
        System.out.println("user = " + user);
    }

    @Test
    public void testSelectAll() {
        List<User> users = mapper.selectAll();
        System.out.println("users = " + users);
    }
}
