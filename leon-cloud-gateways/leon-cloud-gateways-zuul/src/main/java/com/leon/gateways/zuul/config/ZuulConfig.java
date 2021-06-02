package com.leon.gateways.zuul.config;

import com.leon.gateways.zuul.filter.ErrorFilter;
import com.leon.gateways.zuul.filter.TokenFilter;
import com.leon.gateways.zuul.filter.ZuulFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: ZuulConfig
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/2 9:57
 * @Version 1.0
 * @DESCRIPTION:
 **/
@Configuration
public class ZuulConfig {
    /**
     * 添加 token 过滤器
     *
     * @return
     */
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    /**
     * 添加自定义过滤器
     *
     * @return
     */
    @Bean
    public ZuulFilter zuulFilter() {
        return new ZuulFilter();
    }

    /**
     * 添加异常过滤器
     *
     * @return
     */
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
}
