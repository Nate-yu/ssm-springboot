package com.example.rest.crud.service;

import com.example.rest.crud.bean.Employee;

import java.util.List;

public interface EmployeeService {
    // 按照id查询员工
    Employee getEmpById(Long id);

    // 增加员工
    void addEmp(Employee employee);

    // 按照id删除员工
    void deleteEmpById(Long id);

    // 修改员工
    void updateEmp(Employee employee);

    /**
     * 获取所有员工
     * @return
     */
    List<Employee> getAllEmp();
}
