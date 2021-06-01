package com.leon.hystrix.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonHystrixFeignApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 15:47
 * @Version 1.0
 * @DESCRIPTION:
 **/
@EnableFeignClients
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class LeonHystrixFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeonHystrixFeignApplication.class, args);
    }
}
