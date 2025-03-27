package com.example.rest.crud.service.impl;

import com.example.rest.crud.bean.Employee;
import com.example.rest.crud.dao.EmployeeDAO;
import com.example.rest.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;
    @Override
    public Employee getEmpById(Long id) {
        Employee empById = employeeDAO.getEmpById(id);
        return empById;
    }

    @Override
    public void addEmp(Employee employee) {
        employeeDAO.addEmp(employee);
    }

    @Override
    public void deleteEmpById(Long id) {
        employeeDAO.deleteEmpById(id);
    }

    @Override
    public void updateEmp(Employee employee) {
        // 判断传过来的对象中是否存在空值
        Long id = employee.getId();
        if (id == null) {
            return;
        }
        Employee empById = employeeDAO.getEmpById(id);
        if (StringUtils.hasText(employee.getName())) {
            empById.setName(employee.getName());
        }
        if (employee.getAge() != null) {
            empById.setAge(employee.getAge());
        }
        if (StringUtils.hasText(employee.getAddress())) {
            empById.setAddress(employee.getAddress());
        }
        if (employee.getGender() != null) {
            empById.setGender(employee.getGender());
        }
        if (StringUtils.hasText(employee.getEmail())) {
            empById.setEmail(employee.getEmail());
        }
        if (employee.getSalary() != null) {
            empById.setSalary(employee.getSalary());
        }
        employeeDAO.updateEmp(empById);
    }

    @Override
    public List<Employee> getAllEmp() {
        List<Employee> employees = employeeDAO.getAllEmp();
        return employees;
    }
}
