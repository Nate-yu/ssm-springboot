package com.example.mybatis.hello.mapper;

import com.example.mybatis.hello.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public User selectUserById(Integer id);

    public List<User> getAll();

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUserById(Integer id);
}
