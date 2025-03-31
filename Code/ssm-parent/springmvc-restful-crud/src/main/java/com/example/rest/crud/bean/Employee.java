package com.example.rest.crud.bean;

import com.example.rest.crud.annotation.Gender;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Employee {
    private Long id;
    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotNull
    @Max(value = 100, message = "年龄不能大于100")
    @Min(value = 0, message = "年龄不能小于0")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    private String email;

    @Gender(message = "{gender.message}")
    private String gender;
    private String address;
    private BigDecimal salary;
}
