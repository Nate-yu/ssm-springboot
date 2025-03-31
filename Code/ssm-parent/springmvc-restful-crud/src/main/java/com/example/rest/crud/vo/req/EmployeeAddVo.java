package com.example.rest.crud.vo.req;

import com.example.rest.crud.annotation.Gender;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EmployeeAddVo {

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Max(value = 100, message = "年龄不能大于100")
    @Min(value = 0, message = "年龄不能小于0")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    private String email;

    @Gender(message = "{gender.message}")
    private String gender;
    private String address;
    private BigDecimal salary;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;
}
