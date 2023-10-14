package com.hut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


    @RequestMapping("springmvc/hello") // 对外访问的地址
    @ResponseBody // 直接返回字符串到前端，不要找视图解析器
    public String hello() {
        System.out.println("HelloController.java");
        return "hello springmvc";
    }
}
