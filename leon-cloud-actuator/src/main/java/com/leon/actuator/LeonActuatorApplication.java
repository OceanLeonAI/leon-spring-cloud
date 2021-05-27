package com.leon.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonActuatorApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/27 17:43
 * @Version 1.0
 * @DESCRIPTION:
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class LeonActuatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeonActuatorApplication.class, args);
    }
}
