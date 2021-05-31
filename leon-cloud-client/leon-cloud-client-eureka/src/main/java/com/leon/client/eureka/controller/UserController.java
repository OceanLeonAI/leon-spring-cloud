package com.leon.client.eureka.controller;

import com.leon.client.eureka.entity.User;
import com.leon.client.eureka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: UserController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/27 14:53
 * @Version 1.0
 * @DESCRIPTION: User Controller
 **/
@RestController
public class UserController {
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private UserService userService;

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    @GetMapping("/{id:\\d+}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * 获取全部用户
     *
     * @return
     */
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @GetMapping("/hello")
    public String hello() throws InterruptedException {
//        int millis = new Random().nextInt(3000);
//        System.out.println("client线程休眠时间：" + millis);
//        Thread.sleep(millis);
        return "hello from com.leon.client.eureka.controller.UserController.hello()... " + serverPort;
    }
}
