package com.leon.client.nacos.feign;

import com.leon.feign.api.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: NacosApi
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/3 11:25
 * @Version 1.0
 * @DESCRIPTION:
 **/
@FeignClient(value = "leon-cloud-nacos-register")
public interface NacosApi {

    /**
     * 获取字符串信息
     *
     * @return
     */
    @GetMapping("/helloWorld")
    String helloWorld();

    /**
     * 获取用户信息demo
     *
     * @return
     */
    @GetMapping("/user")
    User getUser();
}
