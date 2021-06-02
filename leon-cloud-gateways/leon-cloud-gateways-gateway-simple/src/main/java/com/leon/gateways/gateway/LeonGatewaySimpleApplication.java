package com.leon.gateways.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonGatewaySimpleApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/2 16:13
 * @Version 1.0
 * @DESCRIPTION: 简单网关
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class LeonGatewaySimpleApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(LeonGatewaySimpleApplication.class).run(args);
    }
}
