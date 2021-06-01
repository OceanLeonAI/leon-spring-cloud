package com.leon.hystrix.without.springcloud;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonHystrixCommondFlushCache
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 14:15
 * @Version 1.0
 * @DESCRIPTION: 清空缓存
 **/
@Slf4j
public class LeonHystrixCommondFlushCache extends HystrixCommand<String> {

    public static final HystrixCommandKey TEST_KEY = HystrixCommandKey.Factory.asKey("TestKey");
    private final String name;

    protected LeonHystrixCommondFlushCache(String name) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("myGroup"))
                .andCommandKey(TEST_KEY));
        this.name = name;
    }

    @Override
    protected String run() {
        log.info("get data，{}", this.name);
        return this.name + ":" + Thread.currentThread().getName();
    }

    /**
     * 清理缓存
     *
     * @param name
     */
    private static void flushCache(String name) {
        HystrixRequestCache.getInstance(TEST_KEY,
                HystrixConcurrencyStrategyDefault.getInstance()).clear(name);
    }

    @Override
    protected String getCacheKey() {
        return this.name;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        for (int i = 0; i < 5; i++) {
            LeonHystrixCommondFlushCache test = new LeonHystrixCommondFlushCache("test");
            log.info(test.execute());
            // 清空缓存
            LeonHystrixCommondFlushCache.flushCache("test");
        }
        context.shutdown();
    }
}
