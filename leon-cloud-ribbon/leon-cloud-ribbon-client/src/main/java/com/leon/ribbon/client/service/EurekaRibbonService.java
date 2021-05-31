package com.leon.ribbon.client.service;

import com.leon.ribbon.client.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: EurekaRibbonService
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/31 14:34
 * @Version 1.0
 * @DESCRIPTION:
 **/
@Service
@Slf4j
public class EurekaRibbonService {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 这里需要添加正确的服务名称，RestTemplate 这样请求的好处就是不需要关心应用的IP,
     * 通过Eureka 注册中心发现是此服务名的服务提供者就会去请求。非常方便应用的水平拓展
     *
     * @param id
     * @return
     */
    public User findUserById(Long id) {
        // http://服务提供者的serviceId/url
        return restTemplate.getForObject("http://leon-cloud-ribbon-server/user/" + id, User.class);
    }
}
