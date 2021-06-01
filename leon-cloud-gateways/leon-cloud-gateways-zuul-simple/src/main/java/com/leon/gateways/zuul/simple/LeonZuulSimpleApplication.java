package com.leon.gateways.zuul.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonZuulSimpleApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 17:26
 * @Version 1.0
 * @DESCRIPTION: 简单网关应用
 **/
@EnableZuulProxy
@SpringBootApplication
public class LeonZuulSimpleApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeonZuulSimpleApplication.class, args);
    }
}
