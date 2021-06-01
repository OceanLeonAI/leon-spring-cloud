package com.leon.hystrix.without.springcloud;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonHystrixCollapser
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 14:27
 * @Version 1.0
 * @DESCRIPTION: 合并请求
 **/
@Slf4j
public class LeonHystrixCollapser extends HystrixCollapser<List<String>, String, String> {
    private final String name;

    public LeonHystrixCollapser(String name) {
        this.name = name;
    }

    @Override
    public String getRequestArgument() {
        return this.name;
    }

    @Override
    protected HystrixCommand<List<String>> createCommand(Collection<CollapsedRequest<String, String>> requests) {
        return new LeonBatchCommand(requests);
    }

    @Override
    protected void mapResponseToRequests(List<String> strings, Collection<CollapsedRequest<String, String>> requests) {
        int count = 0;
        for (CollapsedRequest<String, String> request : requests) {
            request.setResponse(strings.get(count++));
        }
    }

    private static final class LeonBatchCommand extends HystrixCommand<List<String>> {

        private Collection<CollapsedRequest<String, String>> requests;

        protected LeonBatchCommand(Collection<CollapsedRequest<String, String>> requests) {
            super(Setter.withGroupKey(
                    HystrixCommandGroupKey.Factory.asKey("testGroup")
                    ).andCommandKey(
                    HystrixCommandKey.Factory.asKey("testKey")
                    )
            );
            this.requests = requests;
        }

        @Override
        protected List<String> run() throws Exception {
            log.info("real request");
            List<String> response = new ArrayList<>();
            for (CollapsedRequest<String, String> request : requests) {
                response.add("result:" + request.getArgument());
            }
            return response;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        Future<String> tesFuture1 = new LeonHystrixCollapser("test1").queue();
        Future<String> tesFuture2 = new LeonHystrixCollapser("test2").queue();
        log.info(tesFuture1.get());
        log.info(tesFuture2.get());
        context.shutdown();
    }
}
