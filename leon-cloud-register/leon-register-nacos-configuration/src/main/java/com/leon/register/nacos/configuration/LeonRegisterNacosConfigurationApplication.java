package com.leon.register.nacos.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonRegisterNacosConfigurationApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/10 11:30
 * @Version 1.0
 * @DESCRIPTION: 从 nacos 读取配置文件 示例
 **/
@SpringBootApplication
public class LeonRegisterNacosConfigurationApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeonRegisterNacosConfigurationApplication.class, args);
    }
}
