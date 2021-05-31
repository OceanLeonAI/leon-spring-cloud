package com.leon.feign.okhttp.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: FeignConfig
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/31 16:44
 * @Version 1.0
 * @DESCRIPTION:
 **/
public class FeignConfig {
    /**
     * 输出的日志级别
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 设置Spring Security Basic认证的用户名密码
     *
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "123456");
    }

    /**
     * 自定义认证逻辑
     *
     * @return
     */
//    @Bean
//    public FeignAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new FeignAuthRequestInterceptor();
//    }

    /**
     * 设置连接超时时间和响应超时时间
     *
     * @return
     */
//    @Bean
//    public Request.Options options() {
//        return new Request.Options(5000, 1000);
//    }

    /**
     * 重试次数
     *
     * @return
     */
//    @Bean
//    public Retryer feignRetryer() {
////        return new Retryer.Default();
//        return new Retryer.Default(100, 1000, 4);
//    }
}
