package com.leon.hystrix.ribbon.service;

import com.leon.hystrix.ribbon.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: EurekaHystrixRibbonService
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 14:38
 * @Version 1.0
 * @DESCRIPTION: Ribbon调用类
 **/
@Service
@Slf4j
public class EurekaHystrixRibbonService {

    @Autowired
    RestTemplate restTemplate;

    //    @HystrixCommand(fallbackMethod = "findUserByIdFailure"
//            , groupKey = "MyGroup"
//            , commandKey = "MyCommandKey"
//            , threadPoolKey = "MyThreadPool"
//            , commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")}
//            , threadPoolProperties = {
//            @HystrixProperty(name = "coreSize", value = "1")}
//            , ignoreExceptions = {Exception.class}
//            , observableExecutionMode = ObservableExecutionMode.EAGER
//            , raiseHystrixExceptions = {HystrixException.RUNTIME_EXCEPTION}
//            , defaultFallback = "findUserByIdFailure"
//    )
    @HystrixCommand(fallbackMethod = "findUserByIdFailure")
    @CacheResult // 对于相同请求，走缓存，配合这个类 HystrixFilter
    public User findUserById(Long id) {
        // http://服务提供者的serviceId/url
        return restTemplate.getForObject("http://leon-cloud-ribbon-server/user/" + id, User.class);
    }

    /**
     * 服务 fw-cloud-feign-server/user/id 调用失败的回调方法
     *
     * @return
     */
    public User findUserByIdFailure(Long id) {
        return new User(id, null, null, null, "网络繁忙，请稍后再试,请确认手牌");
    }

    /**
     * @description 合并请求
     * @author xuyisu
     * @date 2019/12/30
     */
    @HystrixCollapser(batchMethod = "findUsers"
            , scope = com.netflix.hystrix.HystrixCollapser.Scope.REQUEST,
            collapserProperties = {
                    @HystrixProperty(name = "timerDelayInMilliseconds", value = "1000")
            })
    public Future<User> getUserSingle(Long id) {
        log.info("执行单调调用");
        return null;
    }

    /**
     * 请求多个用户数据
     *
     * @param ids
     * @return
     */
    @HystrixCommand(fallbackMethod = "findUsersFailure")
    public List<User> findUsers(List<Long> ids) {
        return restTemplate.getForObject("http://leon-cloud-ribbon-server/user/list?ids=" + StringUtils.join(ids, ","), List.class);
    }

    public List<User> findUsersFailure(List<Long> ids) {
        log.info("fallback");
        List<User> list = new ArrayList<>();
        for (Long id : ids) {
            list.add(new User(id, null, null, null, "网络繁忙，请稍后再试,请确认手牌"));
        }
        return list;
    }
}
