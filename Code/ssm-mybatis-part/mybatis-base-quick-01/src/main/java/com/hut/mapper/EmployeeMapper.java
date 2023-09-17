package com.hut.mapper;

import com.hut.pojo.Employee;

/**
 * 规定数据库方法
 */
public interface EmployeeMapper {

    // 根据id查询员工信息
    Employee queryById(Integer id);

    // 根据id删除员工
    int deleteById(Integer id);
}
