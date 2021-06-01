package com.leon.hystrix.without.springcloud;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonHystrixCommondFallBack
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 14:01
 * @Version 1.0
 * @DESCRIPTION: 回退
 **/
public class LeonHystrixCommondFallBack extends HystrixCommand<String> {
    private final String name;

    protected LeonHystrixCommondFallBack(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("myGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.name + ":" + Thread.currentThread().getName();
    }

    /**
     * 默认情况下调用没在1秒内响应，就会触发回退
     *
     * @return
     */
    @Override
    protected String getFallback() {
        return "当前调用失败";
    }

    public static void main(String[] args) {
        String test = new LeonHystrixCommondFallBack("test").execute();
        System.out.println(test);
    }
}
