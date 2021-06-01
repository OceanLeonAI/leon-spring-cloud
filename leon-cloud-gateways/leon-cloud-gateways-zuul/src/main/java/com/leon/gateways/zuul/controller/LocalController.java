package com.leon.gateways.zuul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LocalController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 18:16
 * @Version 1.0
 * @DESCRIPTION: 本地跳转
 **/
@RestController
public class LocalController {

    /**
     * 本地跳转测试
     *
     * @param id
     * @return
     */
    @GetMapping("/local/user/{id:\\d+}")
    public String getId(@PathVariable Long id) {
        return id.toString() + ",我是forward转发来的";
    }
}
