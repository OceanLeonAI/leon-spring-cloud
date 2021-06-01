package com.leon.feign.without.springcloud.controller;

import com.leon.feign.without.springcloud.entity.User;
import com.leon.feign.without.springcloud.service.HelloClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: UserController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021-05-31 22:56
 * @DESCRIPTION: 测试不在SpringCloud项目里使用Feign
 **/
@RestController
public class UserController {
    /**
     * 测试请求
     *
     * @return
     */
    @GetMapping("/hello")
    public String hello() {
        // com.leon.client.eureka.LeonClientEurekaApplication
        // com.leon.client.eureka.controller.UserController
        HelloClient hello = Feign.builder().target(HelloClient.class, "http://localhost:8763/"); // 实际生成代理调用 8763 的服务
        return hello.hello();
    }

    /**
     * 测试请求根据id获取用户
     *
     * @return
     */
    @GetMapping("/{id:\\d+}")
    public User getUserById(@PathVariable Long id) {
        HelloClient hello = Feign.builder().decoder(new GsonDecoder()).target(HelloClient.class, "http://localhost:8763/");
        return hello.getUserById(id);
    }

    /**
     * 测试请求根据id获取用户
     *
     * @return
     */
    @PostMapping("/getUsers")
    public List<User> getUsers() {
        HelloClient hello = Feign.builder().decoder(new GsonDecoder()).target(HelloClient.class, "http://localhost:8763/");
        return hello.getUsers();
    }
}
