package com.leon.hystrix.without.springcloud;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonHystrixCommondCache
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 14:13
 * @Version 1.0
 * @DESCRIPTION: 结果缓存
 **/
@Slf4j
public class LeonHystrixCommondCache extends HystrixCommand<String> {
    private final String name;

    protected LeonHystrixCommondCache(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("myGrop"));
        this.name = name;
    }

    @Override
    protected String run() {
        log.info("get data，{}", this.name);
        return this.name + ":" + Thread.currentThread().getName();
    }

    @Override
    protected String getCacheKey() {
        return this.name;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        System.out.println("context -> " + context);
        for (int i = 0; i < 5; i++) {
            LeonHystrixCommondCache test = new LeonHystrixCommondCache("test");
            log.info(test.execute());
        }
        context.shutdown();
    }
}
