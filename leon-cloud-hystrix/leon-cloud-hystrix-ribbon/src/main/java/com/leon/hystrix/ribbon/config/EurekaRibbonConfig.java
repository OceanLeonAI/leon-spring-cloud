package com.leon.hystrix.ribbon.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: EurekaRibbonConfig
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 14:41
 * @Version 1.0
 * @DESCRIPTION:
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

        //默认ZoneAvoidanceRule请求,实现自定义的规则
        //自定义成随机

        // 轮训
        return new RoundRobinRule();
    }

    /**
     * 解决dashboard显示 Unable to connect to Command Metric Stream
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
