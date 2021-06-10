package com.leon.register.nacos.configuration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: CustomConfig
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/10 13:55
 * @Version 1.0
 * @DESCRIPTION:
 **/
@Configuration // @Configuration 说明当前 Bean 是一个配置 Bean。是 Spring Boot 自带的 Java Config 注解
@RefreshScope  // @RefreshScope 则用于监听，当 Nacos 推送新的配置后，由这个注解负责接收并为属性重新赋值。
public class CustomConfig {
    @Value("${custom.flag}")
    private String flag;

    @Value("${custom.database}")
    private String database;

    @Value("${custom.message}")
    private String message;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
