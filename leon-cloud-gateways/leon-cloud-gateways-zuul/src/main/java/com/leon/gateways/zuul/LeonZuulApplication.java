package com.leon.gateways.zuul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonZuulApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 17:52
 * @Version 1.0
 * @DESCRIPTION: zuul 网关 demo
 **/
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class LeonZuulApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(LeonZuulApplication.class).run(args);
    }
}
