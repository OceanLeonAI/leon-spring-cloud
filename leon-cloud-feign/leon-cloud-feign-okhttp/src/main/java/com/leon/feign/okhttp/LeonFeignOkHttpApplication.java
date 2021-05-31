package com.leon.feign.okhttp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonFeignApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/31 15:38
 * @Version 1.0
 * @DESCRIPTION:
 **/
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
/**
 * 在启动类上加入@EnableFeignClients注解，如果Feign的定义跟启动类不在一个包名下，
 * 还需要制定路径，如@EnableFeignClients(basePackages = "com.leon.xxx.xxx")
 */
public class LeonFeignOkHttpApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeonFeignOkHttpApplication.class, args);
    }
}
