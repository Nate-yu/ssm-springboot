package com.hut.ioc_03;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;



@Controller
public class UserController {

    //@Autowired // 自动注入（DI）：1. 去ioc容器中查找复合类型的组件对象 2. 设置当前属性
    @Resource(name = "userServiceImpl")
    private UserService userService;

    /**
     * 调用业务层方法
     */
    public void show() {
        String show = userService.show();
        System.out.println(show);
    }
}
