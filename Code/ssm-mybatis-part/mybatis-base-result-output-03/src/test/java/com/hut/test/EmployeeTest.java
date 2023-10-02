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
import java.util.Map;
import java.util.Set;

public class EmployeeTest {

    private SqlSession session;

    private EmployeeMapper mapper;

    // junit5会在每一个@Test方法前执行@BeforeEach方法
    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        mapper = session.getMapper(EmployeeMapper.class);
    }

    @Test
    public void testQueryNameById() {
        String name = mapper.queryNameById(2);
        System.out.println("name = " + name);
    }

    @Test
    public void testQuerySalaryById() {
        Double salary = mapper.querySalaryById(3);
        System.out.println("salary = " + salary);
    }

    @Test
    public void testQueryById() {
        Employee employee = mapper.queryById(5);
        System.out.println("employee = " + employee);
    }

    @Test
    public void testSelectEmpNameAndMaxSalary() {
        Map<String, Object> empMap = mapper.selectEmpNameAndMaxSalary();
        /*Set<Map.Entry<String, Object>> entrySet = empMap.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("value = " + value);
        }*/
        System.out.println("empMap = " + empMap);
    }

    @Test
    public void testQueryNamesBySalary() {
        List<String> names = mapper.queryNamesBySalary(888.0);
        System.out.println("names = " + names);
    }

    @Test
    public void testQueryAll() {
        List<Employee> employees = mapper.queryAll();
        System.out.println("employees = " + employees);
    }

    // junit5会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }
}
