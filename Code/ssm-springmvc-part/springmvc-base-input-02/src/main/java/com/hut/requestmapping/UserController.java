package com.hut.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

    /**
     * 不要求必须使用“/”开头
     * 1. 精准地址，一个或多个 {"path1","path2"}
     * 2. 支持模糊，* 任意一层字符串 | ** 任意层任意字符串
     * 3. 类上和方法上添加@RequestMapping
     *      a. 类上提取通用的访问地址
     *      b. 方法上是具体的handler地址
     * 4. 请求方式指定（get|post|put|delete）
     *      a. 默认情况下，任何方式都可以访问
     *      b. 指定请求方式
     *      c. 不符合请求方式，会报405异常
     * 5. 注解进阶（只能使用在方法上）
     */
//    @RequestMapping(value = "login", method = RequestMethod.POST) // 注册地址，将handler注册到handlerMapping
    @PostMapping("login")
    public String login() {
        return null;
    }

    @RequestMapping(value = "register", method = {RequestMethod.GET, RequestMethod.POST})
    public String register() {
        return null;
    }
}
