package com.leon.hystrix.feign.service;

import com.leon.hystrix.feign.fallback.EurekaFeignServiceFailure;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: EurekaFeignService
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 15:48
 * @Version 1.0
 * @DESCRIPTION:
 **/
@FeignClient(value = "leon-register-eureka-client", fallback = EurekaFeignServiceFailure.class)
public interface EurekaFeignService {
    //feign中你可以有多个@RequestParam，但只能有不超过一个@RequestBody

    @GetMapping("/hello")
    String hello();
}
