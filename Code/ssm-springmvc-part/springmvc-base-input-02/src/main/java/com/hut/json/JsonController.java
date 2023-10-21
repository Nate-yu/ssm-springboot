package com.hut.json;

import com.hut.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("json")
@ResponseBody
public class JsonController {

    // 配置json：1. 导入json处理的依赖，2. handlerAdapter配置json转化器
    @PostMapping("data")
    public String data(@RequestBody Person person) {
        System.out.println("person = " + person);
        return person.toString();
    }
}
