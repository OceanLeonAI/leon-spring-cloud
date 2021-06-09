package com.leon.register.nacos.controller;

import com.leon.feign.api.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: TestController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/3 11:21
 * @Version 1.0
 * @DESCRIPTION:
 **/
@RestController
public class TestController {
    /**
     * 获取字符串信息
     *
     * @return
     */
    @GetMapping("/helloWorld")
    public String HelloWorld() {
        return "Hello World!";
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("/user")
    public User getUser() {
        System.err.println("来自 com.leon.register.nacos.controller.TestController.getUser()...");
        return new User(1L, "nacos", "test", "test@qq.com", "演示Nacos 替换Eureka");
    }
}
