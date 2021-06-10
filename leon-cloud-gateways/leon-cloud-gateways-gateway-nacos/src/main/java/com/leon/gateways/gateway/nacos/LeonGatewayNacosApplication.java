package com.leon.gateways.gateway.nacos;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonGatewayNacosApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/10 10:37
 * @Version 1.0
 * @DESCRIPTION:
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class LeonGatewayNacosApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(LeonGatewayNacosApplication.class).run(args);
    }
}
