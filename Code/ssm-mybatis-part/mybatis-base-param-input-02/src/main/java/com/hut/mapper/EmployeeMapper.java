package com.hut.mapper;

import com.hut.pojo.Employee;

/**
 * 定义员工方法信息
 */
public interface EmployeeMapper {

    // 根据id查询员工信息
    Employee queryById(Integer id);
}
