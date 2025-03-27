package com.example.rest.crud.controller;

import com.example.rest.crud.bean.Employee;
import com.example.rest.crud.common.R;
import com.example.rest.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/v1")
@CrossOrigin // 解决跨域问题，相当于服务器给浏览器的响应头中添加字段：Access-Control-Allow-Origin: *
@RestController
public class EmployeeRestController {
    @Autowired
    EmployeeService employeeService;

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @GetMapping("/employee/{id}")
    public R get(@PathVariable("id") Long id) {
        Employee emp = employeeService.getEmpById(id);
        return R.success(emp);
    }

    /**
     * 新增员工
     * @param employee
     */
    @PostMapping ("/employee")
    public R save(Employee employee) {
        employeeService.addEmp(employee);
        return R.success();
    }

    /**
     * 按照id删除员工
     * @param id
     */
    @DeleteMapping("/employee/{id}")
    public R delete(@PathVariable("id") Long id) {
        employeeService.deleteEmpById(id);
        return R.success();
    }

    /**
     * 修改员工，必须携带id，使用json格式传递
     * @param employee
     */
    @PutMapping("/employee")
    public R update(@RequestBody Employee employee) {
        employeeService.updateEmp(employee);
        return R.success();
    }

    // 查询所有员工的信息
    @GetMapping("/employees")
    public R getAll() {
        List<Employee> employees = employeeService.getAllEmp();
        return R.success(employees);
    }
}
