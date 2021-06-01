package com.leon.hystrix.dashboard;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonHystrixDashboardApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 16:07
 * @Version 1.0
 * @DESCRIPTION: dashborad
 **/
@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class LeonHystrixDashboardApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(LeonHystrixDashboardApplication.class).run(args);
    }
}
