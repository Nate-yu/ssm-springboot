package com.hut.dao.impl;

import com.hut.dao.StudentDao;
import com.hut.pojo.Student;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Resource
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Student> getAll() {
        String sql = "select id , name , age , gender , class as classes from students ;";
        /*
          query可以返回集合
          BeanPropertyRowMapper就是封装好RowMapper的实现,要求属性名和列名相同即可
         */
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }
}
