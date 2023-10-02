package com.hut.mapper;

import com.hut.pojo.Employee;

import java.util.List;
import java.util.Map;

/**
 * 定义员工方法信息
 */
public interface EmployeeMapper {

    // DML语句（删除、修改、插入）
    int deleteById(Integer id);

    // 根据员工id查询员工姓名
    String queryNameById(Integer id);

    // 根据员工id查询员工工资
    Double  querySalaryById(Integer id);

    // 返回单个自定义实体类型
    Employee queryById(Integer id);

    // 查询部门的最高工资与平均工资
    Map<String,Object> selectEmpNameAndMaxSalary();

    // 查询工资高于传入值的员工们的姓名
    List<String> queryNamesBySalary(Double salary);

    // 查询全部员工信息
    List<Employee> queryAll();

    // 插入员工
    int insertEmp(Employee employee);
}
