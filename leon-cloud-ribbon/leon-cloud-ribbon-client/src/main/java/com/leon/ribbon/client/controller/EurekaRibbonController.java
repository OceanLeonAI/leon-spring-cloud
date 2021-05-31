package com.leon.ribbon.client.controller;

import com.leon.ribbon.client.entity.User;
import com.leon.ribbon.client.service.EurekaRibbonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: EurekaRibbonController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/31 14:43
 * @Version 1.0
 * @DESCRIPTION: Ribbon RESTFUL 请求层
 **/
@RestController
public class EurekaRibbonController {
    @Resource
    private EurekaRibbonService eurekaRibbonService;

    /**
     * 根据id获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id:\\d+}")
    public User findUserById(@PathVariable long id) {
        return eurekaRibbonService.findUserById(id);
    }
}
