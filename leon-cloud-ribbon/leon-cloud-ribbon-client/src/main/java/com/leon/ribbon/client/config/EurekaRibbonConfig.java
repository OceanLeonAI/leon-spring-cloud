package com.leon.ribbon.client.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: EurekaRibbonConfig
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/31 14:31
 * @Version 1.0
 * @DESCRIPTION: ribbon配置
 **/
@Configuration
public class EurekaRibbonConfig {

    @Bean
    @LoadBalanced // 实现负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
