package com.hut.mapper;

import com.hut.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    // 根据员工姓名和工资查询员工信息
    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);
}
