package com.example.rest.crud.controller;

import com.example.rest.crud.bean.Employee;
import com.example.rest.crud.common.R;
import com.example.rest.crud.service.EmployeeService;
import com.example.rest.crud.vo.req.EmployeeAddVo;
import com.example.rest.crud.vo.req.EmployeeUpdateVo;
import com.example.rest.crud.vo.resp.EmployRespVo;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        EmployRespVo employRespVo = new EmployRespVo();
        BeanUtils.copyProperties(emp, employRespVo);
        return R.success(employRespVo);
    }

    /**
     * 新增员工
     * @param vo
     */
    @PostMapping ("/employee")
    public R save(@RequestBody @Valid EmployeeAddVo vo) {
        // 将前端数据封装的vo转换为数据库的do
        Employee employee = new Employee();
        // 属性对转
        BeanUtils.copyProperties(vo, employee);
        // 调用业务层方法
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
     * @param vo
     */
    @PutMapping("/employee")
    public R update(@RequestBody @Valid EmployeeUpdateVo vo) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(vo, employee);
        employeeService.updateEmp(employee);
        return R.success();
    }

    // 查询所有员工的信息
    @GetMapping("/employees")
    public R getAll() {
        List<Employee> employees = employeeService.getAllEmp();
        List<EmployRespVo> employRespVos = new ArrayList<>();
        for(Employee employee : employees) {
            EmployRespVo employRespVo = new EmployRespVo();
            BeanUtils.copyProperties(employee, employRespVo);
            employRespVos.add(employRespVo);
        }
        return R.success(employRespVos);
    }
}
