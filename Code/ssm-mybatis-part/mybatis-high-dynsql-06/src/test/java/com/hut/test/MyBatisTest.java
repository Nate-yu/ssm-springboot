package com.hut.test;

import com.hut.mapper.EmployeeMapper;
import com.hut.pojo.Employee;
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

        // junit5会在每一个@Test方法前执行@BeforeEach方法
        @BeforeEach
        public void init() throws IOException {
            session = new SqlSessionFactoryBuilder()
                    .build(Resources.getResourceAsStream("mybatis-config.xml")).openSession(true);

        }

        // junit5会在每一个@Test方法后执行@@AfterEach方法
        @AfterEach
        public void clear() {
            session.close();
        }

        @Test
        public void test_01() {
            EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
            List<Employee> list = employeeMapper.query(null, 101.0);
            System.out.println("list = " + list);
    }
}
