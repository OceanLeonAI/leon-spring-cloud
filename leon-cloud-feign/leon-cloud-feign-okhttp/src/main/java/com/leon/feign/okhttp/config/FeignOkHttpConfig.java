package com.leon.feign.okhttp.config;

import feign.Feign;
import okhttp3.ConnectionPool;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: FeignOkHttpConfig
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/31 17:44
 * @Version 1.0
 * @DESCRIPTION:
 **/
@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignOkHttpConfig {
    @Bean
    public okhttp3.OkHttpClient okHttpClient() {
        return new okhttp3.OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)  //设置读取超时时间
                .connectTimeout(60, TimeUnit.SECONDS) //设置连接超时时间
                .writeTimeout(120, TimeUnit.SECONDS) //设置写入超时时间
                .connectionPool(new ConnectionPool())
                .addInterceptor(new OkHttpLogInterceptor())
                .build();
    }
}
