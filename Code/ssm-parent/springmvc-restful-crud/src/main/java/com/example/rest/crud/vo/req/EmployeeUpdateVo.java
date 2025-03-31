package com.example.rest.crud.vo.req;

import com.example.rest.crud.annotation.Gender;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmployeeUpdateVo {
    @NotNull(message = "员工id不能为空")
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;
}
