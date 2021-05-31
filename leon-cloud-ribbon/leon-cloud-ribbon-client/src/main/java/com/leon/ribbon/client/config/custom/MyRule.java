package com.leon.ribbon.client.config.custom;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Random;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: MyRule
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/31 14:51
 * @Version 1.0
 * @DESCRIPTION: 自定义负载规则
 **/
@Slf4j
public class MyRule implements IRule {

    private ILoadBalancer loadBalancer;

    @Override
    public Server choose(Object o) {
        List<Server> allServers = loadBalancer.getAllServers();
        // //输出一遍提供者实例
        allServers.stream().forEach(server -> System.out.println("HostPort -> " + server.getHostPort()));
        if (CollectionUtils.isEmpty(allServers)) {
            log.info("当前不存在负载调用的提供者实例");
            return null;
        }

        // 永远返回第一个
//        return allServers.get(0);

        // 随机返回一个
        return allServers.get(new Random().nextInt(allServers.size()));
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.loadBalancer = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.loadBalancer;
    }
}
