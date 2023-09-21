package com.hut.mapper;

import com.hut.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 定义员工方法信息
 */
public interface EmployeeMapper {

    // 根据id查询员工信息
    Employee queryById(Integer id);

    // 根据id删除员工信息
    int deleteById(Integer id);

    // 根据工资查询员工信息
    List<Employee> queryBySalary(Double salary);

    // 插入员工数据【实体对象】
    int insertEmp(Employee employee);

    // 根据员工姓名和工资查询员工信息
    List<Employee> queryByNameAndSalary(@Param("name") String name, @Param("salary") Double salary);

    // 插入员工数据【map(name, salary)】
    // 注意：mapper接口中不允许重载
    int insertEmpMap(Map data);
}
