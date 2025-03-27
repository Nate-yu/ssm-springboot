package com.example.rest.crud.dao;

import com.example.rest.crud.bean.Employee;

import java.util.List;

public interface EmployeeDAO {
    /**
     * 按照id查员工
     * @param id
     * @return
     */
    public Employee getEmpById(Long id);


    /**
     * 添加员工
     * @param employee
     */
    public void addEmp(Employee employee);

    /**
     * 修改员工
     * @param employee
     */
    public void updateEmp(Employee employee);

    /**
     * 按照id删除员工
     * @param id
     */
    public void deleteEmpById(Long id);

    /**
     * 查询所有员工的信息
     * @return
     */
    List<Employee> getAllEmp();
}
