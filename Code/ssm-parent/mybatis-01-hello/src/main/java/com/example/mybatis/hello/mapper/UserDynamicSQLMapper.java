package com.example.mybatis.hello.mapper;

import com.example.mybatis.hello.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserDynamicSQLMapper {

    // 根据用户名和用户薪资动态查询用户
    List<User> selectUserByUserNameAndUserSalary(@Param("userName") String userName, @Param("userSalary") Double userSalary);

    // 动态更新用户信息
    int updateUser(User user);
}
