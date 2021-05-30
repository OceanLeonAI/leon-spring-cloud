package com.leon.actuator.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: MyHealthIndicator
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021-05-30 21:52
 * @DESCRIPTION: 自定义健康检查器
 **/
@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        if (HealthStatus.isVisited) {
            // 成功与第三方连接
            return new Health.Builder(Status.UP).build();
        } else {
            // 和第三方连接失败
            return new Health.Builder(Status.DOWN).build();
        }
    }
}
