package com.leon.actuator.controller;

import com.leon.actuator.config.HealthStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: MyHealthController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/27 18:50
 * @Version 1.0
 * @DESCRIPTION: 模拟是否可与第三方访问
 **/
@RestController
@Slf4j
public class MyHealthController {

    @PostMapping("/healthStatus")
    public ResponseEntity<String> healthStatus(boolean isHealth) {
        HealthStatus.isVisited = isHealth;
        log.info("当前与第三方连接是否可用,{}", isHealth);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
