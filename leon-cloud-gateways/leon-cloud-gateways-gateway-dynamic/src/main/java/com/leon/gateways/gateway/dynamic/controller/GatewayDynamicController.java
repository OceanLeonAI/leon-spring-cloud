package com.leon.gateways.gateway.dynamic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: GatewayDynamicController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/3 10:21
 * @Version 1.0
 * @DESCRIPTION:
 **/
@RestController
@RequestMapping("/gatewayDynamic")
public class GatewayDynamicController {

    /**
     * helloMusic
     *
     * @return
     */
    @RequestMapping("/helloMusic")
    public String helloMusic() {
        return "hello music";
    }

    /**
     * helloSearch
     *
     * @return
     */
    @RequestMapping("/helloSearch")
    public String helloSearch() {
        return "hello search";
    }
}
