package com.leon.mq.kafka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonKafkaMqApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/2 14:34
 * @Version 1.0
 * @DESCRIPTION: kafka 应用案例
 **/
@SpringBootApplication
public class LeonKafkaMqApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(LeonKafkaMqApplication.class).run(args);
    }
}
