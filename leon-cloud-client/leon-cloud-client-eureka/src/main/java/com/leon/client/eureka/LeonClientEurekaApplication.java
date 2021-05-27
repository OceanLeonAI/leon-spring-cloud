package com.leon.client.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonClientEurekaApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/27 14:40
 * @Version 1.0
 * @DESCRIPTION: Eureka 客户端
 **/
@SpringBootApplication
@EnableEurekaClient
public class LeonClientEurekaApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(LeonClientEurekaApplication.class).run(args);
    }
}
