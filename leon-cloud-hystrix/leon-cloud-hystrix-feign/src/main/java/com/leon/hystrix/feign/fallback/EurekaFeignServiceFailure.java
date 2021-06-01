package com.leon.hystrix.feign.fallback;

import com.leon.hystrix.feign.service.EurekaFeignService;
import org.springframework.stereotype.Service;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: EurekaFeignServiceFailure
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 15:49
 * @Version 1.0
 * @DESCRIPTION:
 **/
@Service
public class EurekaFeignServiceFailure implements EurekaFeignService {
    @Override
    public String hello() {
        return "网络异常,稍后再试,请拿好手牌";
    }
}
