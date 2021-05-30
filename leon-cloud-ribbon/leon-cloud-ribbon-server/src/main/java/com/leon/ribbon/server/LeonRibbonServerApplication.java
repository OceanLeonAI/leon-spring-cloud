package com.leon.ribbon.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonRibbonServerApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021-05-30 22:34
 * @DESCRIPTION:
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class LeonRibbonServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeonRibbonServerApplication.class, args);
    }
}

