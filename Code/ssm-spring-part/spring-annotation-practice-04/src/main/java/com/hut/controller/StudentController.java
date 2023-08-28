package com.hut.controller;

import com.hut.pojo.Student;
import com.hut.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    // 查询所有学生
    public void getAllStudent() {
        List<Student> allStudents = studentService.getAllStudents();
        System.out.println("allStudents = " + allStudents);
    }
}
