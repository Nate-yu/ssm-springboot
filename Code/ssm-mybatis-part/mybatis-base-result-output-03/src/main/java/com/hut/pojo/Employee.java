package com.hut.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("employee") // 在不想使用默认批量别名时，使用此注解
public class Employee {

    private Integer empId;

    private String empName;

    private Double empSalary;

}