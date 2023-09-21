package test;

import com.hut.mapper.EmployeeMapper;
import com.hut.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class InputParamTest {

    private SqlSession session;

    private EmployeeMapper mapper;

    // junit5会在每一个@Test方法前执行@BeforeEach方法
    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        mapper = session.getMapper(EmployeeMapper.class);
    }

    @Test
    public void testDeleteById() {
        int row = mapper.deleteById(1);
        if (row == 1) {
            System.out.println("删除成功！");
        }
    }

    @Test
    public void testQueryBySalary() {
        List<Employee> employees = mapper.queryBySalary(777.77);
        System.out.println("employees = " + employees);
    }

    @Test
    public void testInsertEmp() {
        Employee employee = new Employee();
        employee.setEmpSalary(888.88);
        employee.setEmpName("余鸿翔");
        int row = mapper.insertEmp(employee);
        if (row == 1) {
            System.out.println("插入成功！");
        }
    }

    @Test
    public void testQueryByNameAndSalary() {
        List<Employee> employees = mapper.queryByNameAndSalary("余鸿翔", 888.88);
        System.out.println("employees = " + employees);
    }

    @Test
    public void testInsertEmpMap() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("salary", 999.99);
        paramMap.put("name","Nate");
        int row = mapper.insertEmpMap(paramMap);
        if (row == 1) {
            System.out.println("插入成功！");
        }
    }

    // junit5会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }
}
