package com.leon.register.nacos.configuration.controller;

import com.leon.register.nacos.configuration.config.CustomConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: TestController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/10 11:35
 * @Version 1.0
 * @DESCRIPTION:
 **/
@RestController
public class TestController {

// 这种写法，nacos 改变数据后，需要重启才会读取最新配置，需要动态配置需要 ${@link com.leon.register.nacos.configuration.config.CustomConfig}
//    @Value("${custom.flag}")
//    private String flag;
//
//    @Value("${custom.database}")
//    private String database;
//
//    @Value("${custom.message}")
//    private String message;

    @Resource
    private CustomConfig customConfig;

    @GetMapping("/test")
    public String test() {
        return "flag:" + customConfig.getFlag() + "<br/> database:" + customConfig.getDatabase()
                + " message -> " + customConfig.getMessage();
    }
}
