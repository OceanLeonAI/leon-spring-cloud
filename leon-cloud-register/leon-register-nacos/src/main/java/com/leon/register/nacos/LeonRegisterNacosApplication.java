package com.leon.register.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonRegisterNacosApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/3 11:22
 * @Version 1.0
 * @DESCRIPTION:
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class LeonRegisterNacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeonRegisterNacosApplication.class, args);
    }
}
