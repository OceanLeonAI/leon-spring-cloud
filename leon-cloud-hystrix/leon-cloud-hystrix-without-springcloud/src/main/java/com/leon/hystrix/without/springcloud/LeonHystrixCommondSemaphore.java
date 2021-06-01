package com.leon.hystrix.without.springcloud;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonHystrixCommondSemaphore
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 14:03
 * @Version 1.0
 * @DESCRIPTION: 信号量
 * Hystrix提供了两种隔离机制，信号量（SEMAPHORE）和线程（THREAD）隔离,我们先看信号量的隔离
 * 当请求的并发数高于设定的阀值时，就不会再执行命令。相对于线程池机制，信号量的开销较小，
 * 但是信号量机制不支持超时和异步，除非对调用的服务有足够的信任，否则不建议使用信号量机制进行隔离。
 **/
@Slf4j
public class LeonHystrixCommondSemaphore extends HystrixCommand<String> {
    private final String name;

    /**
     * 需要在构造方法中指定SEMAPHORE机制，这里我们用默认的最大并发数（10）和回退并发数（10），开20线程进行测试。
     *
     * @param name
     */
    protected LeonHystrixCommondSemaphore(String name) {
        super(HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("myGroup"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter().withExecutionIsolationStrategy(
                                HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE
                        )
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
        for (int i = 0; i < 20; i++) {
            final int index = i;
            Thread t = new Thread() {
                @Override
                public void run() {
                    LeonHystrixCommondSemaphore test = new LeonHystrixCommondSemaphore("test" + index);
                    test.execute();
                }
            };
            t.start();
        }
        Thread.sleep(5000);

    }
}
