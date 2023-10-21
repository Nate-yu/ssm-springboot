package com.hut.path;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 路径参数
 */
@Controller
@RequestMapping("path")
@ResponseBody
public class PathController {

    // path/账号/密码

    /**
     * 动态路径设计 {key}表示在形参列表获取传入的参数
     * 必须使用@PathVariable注解来表示接收路径参数
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("{account}/{password}")
    public String login(@PathVariable(value = "account") String username, @PathVariable String password) {
        System.out.println("username = " + username + ", password = " + password);
        return "username = " + username + ", password = " + password;
    }
}
