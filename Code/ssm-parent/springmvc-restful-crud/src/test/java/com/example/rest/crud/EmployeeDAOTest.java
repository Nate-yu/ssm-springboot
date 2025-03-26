package com.example.rest.crud;

import com.example.rest.crud.bean.Employee;
import com.example.rest.crud.dao.EmployeeDAO;
import com.example.rest.crud.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class EmployeeDAOTest {

    @Autowired
    EmployeeDAO employeeDAO;

    /**
     * 测试查询员工
     */
    @Test
    public void testGetEmpById() {
        System.out.println(employeeDAO.getEmpById(1L));
    }

    /**
     * 测试新增员工
     */
    @Test
    public void testAddEmp() {
        Employee employee = new Employee();
        employee.setName("test");
        employee.setAge(18);
        employee.setEmail("test@163.com");
        employee.setGender("男");
        employee.setAddress("test");
        employee.setSalary(new BigDecimal(10000.00));
        employeeDAO.addEmp(employee);
        System.out.println("新增成功！");
    }

    /**
     * 测试修改员工信息
     */
    @Test
    public void testUpdateEmp() {
        Employee employee = new Employee();
        employee.setId(6L);
        employee.setName("test");
        employee.setAge(18);
        employee.setEmail("test@163.com");
        employee.setGender("男");
        employee.setAddress("test");
        employee.setSalary(new BigDecimal(10.00));
        employeeDAO.updateEmp(employee);
        System.out.println("修改成功！");
    }

    /**
     * 测试根据Id删除员工
     */
    @Test
    public void testDeleteEmpById() {
        employeeDAO.deleteEmpById(6L);
    }
}
