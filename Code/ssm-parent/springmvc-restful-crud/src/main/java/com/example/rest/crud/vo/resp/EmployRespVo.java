package com.example.rest.crud.vo.resp;

import lombok.Data;

import java.math.BigDecimal;
@Data
// 假设age是敏感数据
public class EmployRespVo {
    private Long id;
    private String name;
//    private Integer age;
    private String email; 
    private String gender;
    private String address;
    private BigDecimal salary;
}
