package com.hut.controller;

import com.hut.pojo.Student;
import com.hut.service.StudentService;

import java.util.List;

public class StudentController {

    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void findAll() {
        List<Student> all = studentService.findAll();
        System.out.println("最终所有学员数据为：" + all);
    }
}
