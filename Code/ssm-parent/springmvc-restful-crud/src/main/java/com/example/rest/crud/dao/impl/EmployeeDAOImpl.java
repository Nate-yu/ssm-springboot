package com.example.rest.crud.dao.impl;

import com.example.rest.crud.bean.Employee;
import com.example.rest.crud.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Employee getEmpById(Long id) {
        String sql = "select * from employee where id = ?";
        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
        return employee;
    }

    @Override
    public void addEmp(Employee employee) {
        String sql = "insert into employee(name, age, email, gender, address, salary,birth) values (?, ?, ?, ?, ?, ?, ?)";
        int update = jdbcTemplate.update(sql,
                employee.getName(),
                employee.getAge(),
                employee.getEmail(),
                employee.getGender(),
                employee.getAddress(),
                employee.getSalary(),
                employee.getBirth());
        System.out.println("新增成功，影响行数：" + update);
    }

    @Override
    public void updateEmp(Employee employee) {
        String sql = "update employee set name = ?, age = ?, email = ?, gender = ?, address = ?, salary = ? where id = ?";
        int update = jdbcTemplate.update(sql,
                employee.getName(),
                employee.getAge(),
                employee.getEmail(),
                employee.getGender(),
                employee.getAddress(),
                employee.getSalary(),
                employee.getId());
        System.out.println("更新成功，影响行数：" + update);
    }

    @Override
    public void deleteEmpById(Long id) {
        String sql = "delete from employee where id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println("删除成功，影响行数：" + update);
    }

    @Override
    public List<Employee> getAllEmp() {
        String sql = "select id,name,age,email,gender,address,salary from employee";
        List<Employee> employees = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
        return employees;
    }
}
