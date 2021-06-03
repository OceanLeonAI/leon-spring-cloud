package com.leon.client.nacos;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonClientNacosApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/3 11:29
 * @Version 1.0
 * @DESCRIPTION:
 **/
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class LeonClientNacosApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(LeonClientNacosApplication.class).run(args);
    }
}
