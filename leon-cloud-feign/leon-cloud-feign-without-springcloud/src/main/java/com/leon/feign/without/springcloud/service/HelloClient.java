package com.leon.feign.without.springcloud.service;

import com.leon.feign.without.springcloud.entity.User;
import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: HelloClient
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021-05-31 22:55
 * @DESCRIPTION: 原生的Feign 使用的是@RequestLine("GET /hello")形式的接口，里面是请求方式和接口名称，中间用空格间隔开。
 **/
public interface HelloClient {
    @RequestLine("GET /hello")
    String hello();

    @RequestLine("GET /{id:\\d+}")
    User getUserById(@Param("id") Long id);

    @RequestLine("POST /getUsers")
    List<User> getUsers();
}
