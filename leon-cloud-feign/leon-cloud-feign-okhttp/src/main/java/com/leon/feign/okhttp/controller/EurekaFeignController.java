package com.leon.feign.okhttp.controller;

import com.leon.feign.okhttp.service.EurekaFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: EurekaFeignController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/31 15:47
 * @Version 1.0
 * @DESCRIPTION:
 **/
@RestController
@Slf4j
public class EurekaFeignController {
    @Resource
    private EurekaFeignService eurekaFeignService;

    @GetMapping("/feignInfo")
    public String feignInfo() {
        String message = eurekaFeignService.hello();
        log.info(message);
        return message;
    }
}
