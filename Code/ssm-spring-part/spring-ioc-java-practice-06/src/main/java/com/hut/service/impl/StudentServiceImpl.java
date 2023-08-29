package com.hut.service.impl;

import com.hut.dao.StudentDao;
import com.hut.pojo.Student;
import com.hut.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAll();
    }
}
