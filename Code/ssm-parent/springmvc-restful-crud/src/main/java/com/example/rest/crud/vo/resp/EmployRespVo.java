package com.example.rest.crud.vo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;
}
