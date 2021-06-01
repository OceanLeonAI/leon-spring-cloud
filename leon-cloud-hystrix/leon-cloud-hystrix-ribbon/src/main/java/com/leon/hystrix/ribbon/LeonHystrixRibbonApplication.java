package com.leon.hystrix.ribbon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonHystrixRibbonApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 14:34
 * @Version 1.0
 * @DESCRIPTION:
 **/
@EnableHystrix
@SpringBootApplication
public class LeonHystrixRibbonApplication {
    public static void main(String[] args) {
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(LeonHystrixRibbonApplication.class);
        springApplicationBuilder.run(args);
    }
}
