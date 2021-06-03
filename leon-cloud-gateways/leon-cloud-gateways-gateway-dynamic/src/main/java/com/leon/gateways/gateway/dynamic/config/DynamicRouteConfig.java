package com.leon.gateways.gateway.dynamic.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: DynamicRouteConfig
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/3 10:03
 * @Version 1.0
 * @DESCRIPTION: 动态路由分配
 **/
@Slf4j
@Configuration
public class DynamicRouteConfig {
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {

        log.info("进入 Java 方式 route 配置...");
        return builder.routes()
                .route("music", // id
                        r -> r
                                .path("/api/music") // 断言，匹配路径转发
                                .uri("localhost:8888/gatewayDynamic/helloMusic") // 被转发地址
                )
                .route("search", // id
                        r -> r
                                .path("/api/search") // 断言，匹配路径转发
                                .uri("localhost:8888/gatewayDynamic/helloSearch") // 被转发地址
                )
                .build();
    }
}
