package com.leon.hystrix.turbine;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonTurbineApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 16:22
 * @Version 1.0
 * @DESCRIPTION:
 **/
@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class LeonTurbineApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(LeonTurbineApplication.class).run(args);
    }
}
