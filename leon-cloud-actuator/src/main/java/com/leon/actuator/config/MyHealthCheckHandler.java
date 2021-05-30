package com.leon.actuator.config;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: MyHealthCheckHandler
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021-05-30 22:16
 * @DESCRIPTION: 健康检查处理器
 **/
@Component
@Slf4j
public class MyHealthCheckHandler implements HealthCheckHandler {
    @Autowired
    MyHealthIndicator myHealthIndicator;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
        if (myHealthIndicator.health().getStatus().equals(Status.UP)) {
            log.info("第三方服务可以正常访问");
            return InstanceInfo.InstanceStatus.UP;
        } else {
            log.info("第三方服务访问异常");
            return InstanceInfo.InstanceStatus.DOWN;
        }
    }
}
