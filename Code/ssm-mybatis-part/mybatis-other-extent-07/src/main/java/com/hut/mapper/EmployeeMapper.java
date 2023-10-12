package com.hut.mapper;

import com.hut.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    List<Employee> queryAll();
}
