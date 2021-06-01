package com.leon.hystrix.feign.controller;

import com.leon.hystrix.feign.service.EurekaFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: EurekaFeignController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 15:51
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
