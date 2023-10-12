package com.hut.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    // 测试使用分页插件
    @Test
    public void test_01() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        // 调用之前，先设置分页数据(从第几页开始查，每页显示多少)
        PageHelper.startPage(1,2);

        // TODO: 注意，不能将两条查询装到一个分页区
        List<Employee> employees = mapper.queryAll();

        // 将查询数据封装到一个PageInfo的分页实体类（一共有多少页，一共有多少条）
        PageInfo<Employee> employeePageInfo = new PageInfo<>(employees);
        // pageInfo获取分页的数据
        // 当前页的数据，总页数，总条数，页面数，每页的条数
        List<Employee> list1 = employeePageInfo.getList();
        System.out.println("list1 = " + list1);
        int pages = employeePageInfo.getPages();
        System.out.println("pages = " + pages);
        long total = employeePageInfo.getTotal();
        System.out.println("total = " + total);
        int pageNum = employeePageInfo.getPageNum();
        System.out.println("pageNum = " + pageNum);
        int pageSize = employeePageInfo.getPageSize();
        System.out.println("pageSize = " + pageSize);
    }
}
