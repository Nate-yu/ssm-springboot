package com.hut.test;

import com.hut.mapper.EmployeeMapper;
import com.hut.mapper.TeacherMapper;
import com.hut.pojo.Employee;
import com.hut.pojo.Teacher;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class MyBatisTest {

    @Test
    public void test_01() throws IOException {
        // 1. 读取外部配置文件（mybatis-config.xml）
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        // 2. 创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        // 3. 根据sqlSessionFactory创建sqlSession（每次业务创建一个，用完就释放）
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 4. 获取代理对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setEmpName("abin");
        employee.setEmpSalary(1000.0);

        int rows = mapper.insertEmp(employee);
        System.out.println(employee.getEmpId());
        System.out.println("rows = " + rows);

        // 5. 释放资源 和 提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test_02() throws IOException {
        // 1. 读取外部配置文件（mybatis-config.xml）
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

        // 2. 创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        // 3. 根据sqlSessionFactory创建sqlSession（每次业务创建一个，用完就释放）
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // 开启自动提交

        // 4. 获取代理对象
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher();
        teacher.setTName("wwww");
        /*// 使用UUID自己维护主键
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        teacher.setTId(id);*/
        System.out.println(teacher.getTId());
        int rows = mapper.insertTeacher(teacher);
        System.out.println("rows = " + rows);
        System.out.println(teacher.getTId());

        // 5. 释放资源 和 提交事务
//        sqlSession.commit();
        sqlSession.close();
    }
}
