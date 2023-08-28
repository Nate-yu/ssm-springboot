package com.hut.service;

import com.hut.pojo.Student;

import java.util.List;

public interface StudentService {

    /**
     * 查询全部学生业务
     * @return
     */
    List<Student> getAllStudents();
}
