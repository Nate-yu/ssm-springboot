package com.hut.param;

import com.hut.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 如何接收前端param参数
 */
@Controller
@RequestMapping("param")
public class ParamController {
    // 1. 直接接收
    // 请求参数名 = 形参参数名
    // 名称相同，可以不传递
    @RequestMapping("data")
    @ResponseBody
    public String data(String name, int age) {
        System.out.println("name = " + name + ", age = " + age);
        return "name = " + name + ", age = " + age;
    }

    // 2. 注解指定
    // 指定请求参数名，或者是否必须传递，或者非必须传递设置默认值
    // 如果形参名和请求参数名一致，可以省略
    @GetMapping("data1")
    @ResponseBody
    public String data1(@RequestParam(value = "account") String username,
                        @RequestParam(required = false, defaultValue = "1") int page) {
        System.out.println("username = " + username + ", page = " + page);
        return "username = " + username + ", page = " + page;
    }

    // 3. 特殊值
    // 一名多值，直接使用集合接值即可
    @GetMapping("data2")
    @ResponseBody
    public String data2(@RequestParam List<String> hbs) {
        System.out.println("hbs = " + hbs);
        return "ok";
    }

    // 4. 使用实体对象赋值 【用户信息】
    @GetMapping("data3")
    @ResponseBody
    public String data3(User user) {
        System.out.println("user = " + user);
        return user.toString();
    }
}
