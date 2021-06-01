package com.leon.hystrix.without.springcloud;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonHystrixCommondThread
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 14:07
 * @Version 1.0
 * @DESCRIPTION: 线程隔离
 **/
@Slf4j
public class LeonHystrixCommondThread extends HystrixCommand<String> {
    private final String name;

    protected LeonHystrixCommondThread(String name) {
        super(Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("myGroup"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter().withExecutionIsolationStrategy(
                                HystrixCommandProperties.ExecutionIsolationStrategy.THREAD
                        )
                ).andThreadPoolPropertiesDefaults(
                        HystrixThreadPoolProperties.Setter()
                                .withCoreSize(3) // 设置核心线程数
                ));
        this.name = name;
    }

    @Override
    protected String getFallback() {
        log.info(this.name + ":" + Thread.currentThread().getName() + "异常");
        return this.name + ":" + Thread.currentThread().getName();
    }

    @Override
    protected String run() throws Exception {
        log.info(this.name + ":" + Thread.currentThread().getName() + "成功");
        return this.name + ":" + Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 6; i++) {
            final int index = i;
            Thread t = new Thread() {
                @Override
                public void run() {
                    LeonHystrixCommondThread test = new LeonHystrixCommondThread("test" + index);
                    test.execute();
                }
            };
            t.start();
        }
        Thread.sleep(5000);
    }
}
