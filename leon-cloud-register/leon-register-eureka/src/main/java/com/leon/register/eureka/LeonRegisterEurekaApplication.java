package com.leon.register.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonRegisterEurekaApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/27 13:58
 * @Version 1.0
 * @DESCRIPTION: Eureka 注册中心 服务端
 **/
@SpringBootApplication
@EnableEurekaServer
public class LeonRegisterEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeonRegisterEurekaApplication.class, args);
    }
}
