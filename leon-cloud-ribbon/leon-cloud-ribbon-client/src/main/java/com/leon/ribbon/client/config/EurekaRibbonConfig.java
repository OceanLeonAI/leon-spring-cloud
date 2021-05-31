package com.leon.ribbon.client.config;

import com.leon.ribbon.client.config.custom.MyRule;
import com.netflix.loadbalancer.IRule;
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

    @Bean
    public IRule ribbonRule() {
        // 自定义负载均衡采取随机策略
//        return new RandomRule();

        // 轮询
//        return new RoundRobinRule();

        // 自定义规则
        return new MyRule();
    }
}
