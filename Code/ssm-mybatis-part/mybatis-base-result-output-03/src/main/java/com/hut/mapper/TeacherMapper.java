package com.hut.mapper;

import com.hut.pojo.Teacher;

public interface TeacherMapper {
    int insertTeacher(Teacher teacher);

    Teacher queryById(Integer tId);
}
