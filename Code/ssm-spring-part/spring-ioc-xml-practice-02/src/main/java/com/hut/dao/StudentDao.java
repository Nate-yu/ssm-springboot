package com.hut.dao;

import com.hut.pojo.Student;

import java.util.List;

/**
 * 数据层接口
 */
public interface StudentDao {

    /**
     *  查询所有学生
     * @return
     */
    List<Student> queryAll();
}
