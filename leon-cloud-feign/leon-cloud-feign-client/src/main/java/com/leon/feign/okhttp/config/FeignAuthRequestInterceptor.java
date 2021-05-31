package com.leon.feign.okhttp.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: FeignAuthRequestInterceptor
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/31 16:51
 * @Version 1.0
 * @DESCRIPTION: 自定义认证方式
 **/
public class FeignAuthRequestInterceptor implements RequestInterceptor {
    /**
     * @param template
     */
    @Override
    public void apply(RequestTemplate template) {
        // 编写自己的业务逻辑
    }
}
