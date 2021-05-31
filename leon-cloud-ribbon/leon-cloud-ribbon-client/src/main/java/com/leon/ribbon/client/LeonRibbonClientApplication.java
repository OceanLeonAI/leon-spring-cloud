package com.leon.ribbon.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonRibbonClientApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/31 14:27
 * @Version 1.0
 * @DESCRIPTION:
 **/
@SpringBootApplication
public class LeonRibbonClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(LeonRibbonClientApplication.class).run(args);
    }
}
