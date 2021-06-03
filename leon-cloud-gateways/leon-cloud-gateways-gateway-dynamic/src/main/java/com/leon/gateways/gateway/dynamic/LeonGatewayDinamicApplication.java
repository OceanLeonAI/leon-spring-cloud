package com.leon.gateways.gateway.dynamic;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonGatewayDinamicApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/3 9:55
 * @Version 1.0
 * @DESCRIPTION: 动态 Gateway 示例
 **/
//@EnableDiscoveryClient
@SpringBootApplication
public class LeonGatewayDinamicApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(LeonGatewayDinamicApplication.class).run(args);
    }
}
