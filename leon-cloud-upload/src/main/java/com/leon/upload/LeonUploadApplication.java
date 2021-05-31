package com.leon.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonUploadApplication
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021-05-31 21:54
 * @DESCRIPTION:
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class LeonUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeonUploadApplication.class, args);
    }
}
