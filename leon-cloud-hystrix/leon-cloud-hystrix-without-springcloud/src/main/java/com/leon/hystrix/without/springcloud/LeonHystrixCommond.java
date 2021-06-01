package com.leon.hystrix.without.springcloud;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonHystrixCommond
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 13:55
 * @Version 1.0
 * @DESCRIPTION: 简单使用
 * 编写一个HystrixCommand的实现类，通过设置一个Groupkey。
 * 具体的逻辑写在 run() 方法中，并在方法中输出当前的线程名，本节我们都将通过main()方法调用
 **/
public class LeonHystrixCommond extends HystrixCommand<String> {

    private final String name;

    protected LeonHystrixCommond(String name) {
        //创建一个组名
        super(HystrixCommandGroupKey.Factory.asKey("myGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return this.name + ":" + Thread.currentThread().getName();
    }

    //    非异步执行
//    public static void main(String[] args) {
//        String test = new LeonHystrixCommond("test").execute();
//        System.out.println(test);
//    }

    //    异步执行
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> test = new LeonHystrixCommond("test").queue();
        System.out.println(test.get());
    }
}
