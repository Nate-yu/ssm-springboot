package com.hut.service.impl;

import com.hut.dao.StudentDao;
import com.hut.pojo.Student;
import com.hut.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        System.out.println("studentService: " + studentList);
        return studentList;
    }
}
