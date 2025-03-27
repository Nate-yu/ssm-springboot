package com.example.rest.crud;

import com.example.rest.crud.bean.Employee;
import com.example.rest.crud.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    EmployeeService employeeService;
    @Test
    public void testUpdateEmp() {
        Employee employee = new Employee();
        employee.setId(3L);
        employee.setName("test2");
        employee.setAddress("tianyuanqu");
        employeeService.updateEmp(employee);
    }
}
