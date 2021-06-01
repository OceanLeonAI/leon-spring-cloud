package com.leon.hystrix.without.springcloud;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import lombok.extern.slf4j.Slf4j;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonHystrixCommondCircuitEnable
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 14:20
 * @Version 1.0
 * @DESCRIPTION: 断路器开启
 * <p>
 * 1.构造一个HystrixCommand或HystrixObservableCommand对象
 * 2.执行命令
 * 3.响应是否已缓存？
 * 4.断路器开了吗？
 * 5.线程池/队列/信号量是否已满？
 * 6。HystrixObservableCommand.construct() 要么 HystrixCommand.run()
 * 7.计算电路健康
 * 8.获取后备
 * 9.返回成功的回应
 * <p>
 * 新建类FwHystrixCommondCircuitEnable，在代码里设置了10秒内有10次请求，操作这个即满足第一个条件，
 * 设置操作时间为500毫秒，但是在run()方法中sleep(800)，这样请求都会超时。开启断路器
 **/
@Slf4j
public class LeonHystrixCommondCircuitEnable {
    public static void main(String[] args) {
        //10秒内有10次请求满足第一个条件
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.circuitBreaker.requestVolumeThreshold", 10);
        for (int i = 0; i < 15; i++) {
            ErrorCommand c = new ErrorCommand();
            c.execute();
            if (c.isCircuitBreakerOpen()) {
                log.info("当前断路器被打开,在第{}索引", i);
            }
        }
    }

    static class ErrorCommand extends HystrixCommand<String> {
        public ErrorCommand() {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(500)));
        }

        protected String run() throws InterruptedException {
            Thread.sleep(800);
            return "success";
        }

        protected String getFallback() {
            return "fallback";
        }
    }
}
