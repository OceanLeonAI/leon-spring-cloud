package com.leon.actuator.config;

import lombok.Data;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: HealthStatus
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/27 18:48
 * @Version 1.0
 * @DESCRIPTION:
 **/
@Data
public class HealthStatus {
    /**
     * 是否是可访问的
     */
    public static boolean isVisited;
}
