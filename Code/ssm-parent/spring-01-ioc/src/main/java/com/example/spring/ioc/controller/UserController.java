package com.example.spring.ioc.controller;

import com.example.spring.ioc.dao.UserDao;
import com.example.spring.ioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import jakarta.annotation.Resource;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private UserDao userDao;

    /**
     * @Autowired 和 @Resource 的区别
     * 1. @Autowired 是 Spring 提供的注解，@Resource 是 Java 提供的注解，@Resource具有更强的通用性
     * 2. @Autowired 是按照类型注入，@Resource 是按照名称注入
     * 3. @Autowired 可以设置 required 属性，@Resource 不能设置 required 属性
     * 4. @Autowired 可以设置 primary 属性，@Resource 不能设置 primary 属性
     * 5. @Autowired 可以设置 qualifier 属性，@Resource 不能设置 qualifier 属性
     * 6. @Autowired 可以设置 autowire 属性，@Resource 不能设置 autowire 属性
     * 7. @Autowired 可以设置 value 属性，@Resource 不能设置 value 属性
     */

}
