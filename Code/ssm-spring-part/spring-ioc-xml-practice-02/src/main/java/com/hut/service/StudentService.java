package com.hut.service;

import com.hut.pojo.Student;

import java.util.List;

/**
 * 学生业务接口
 */
public interface StudentService {

    /**
     * 查询所有学生
     * @return
     */
    List<Student> findAll();
}
