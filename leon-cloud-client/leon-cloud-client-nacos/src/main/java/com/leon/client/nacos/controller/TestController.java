package com.leon.client.nacos.controller;

import com.leon.client.nacos.feign.NacosApi;
import com.leon.feign.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: TestController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/3 11:26
 * @Version 1.0
 * @DESCRIPTION:
 **/
@RestController
public class TestController {
    @Autowired
    private NacosApi nacosApi;

    /**
     * 获取字符串信息
     *
     * @return
     */
    @GetMapping("/hello")
    public String hello() {
        return nacosApi.helloWorld();
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("/user")
    public User user() {
        return nacosApi.getUser();
    }
}
