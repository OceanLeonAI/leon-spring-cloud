package com.leon.feign.okhttp.config;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: OkHttpLogInterceptor
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/31 17:45
 * @Version 1.0
 * @DESCRIPTION: Url 日志
 **/
@Slf4j
public class OkHttpLogInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        log.info("OkHttpUrl : " + chain.request().url());
        return chain.proceed(chain.request());
    }
}
