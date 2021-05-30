package com.leon.actuator.config;

import lombok.Data;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: HealthStatus
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021-05-30 21:53
 * @DESCRIPTION: 健康状态信息
 **/
@Data
public class HealthStatus {
    /**
     * 是否是可访问的
     */
    public static boolean isVisited;
}
