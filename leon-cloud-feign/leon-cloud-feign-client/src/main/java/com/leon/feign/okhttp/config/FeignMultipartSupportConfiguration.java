package com.leon.feign.okhttp.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: FeignMultipartSupportConfiguration
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021-05-31 22:16
 * @DESCRIPTION:
 **/
@Configuration
public class FeignMultipartSupportConfiguration {
    /**
     * Feign Spring 表单编码器
     *
     * @return 表单编码器
     */
    @Bean
    @Primary
    @Scope("prototype")
    public Encoder multipartEncoder() {
        return new SpringFormEncoder();
    }
}
