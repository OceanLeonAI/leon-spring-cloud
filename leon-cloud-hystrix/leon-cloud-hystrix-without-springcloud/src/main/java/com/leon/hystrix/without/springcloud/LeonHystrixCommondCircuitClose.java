package com.leon.hystrix.without.springcloud;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandMetrics;
import com.netflix.hystrix.HystrixCommandProperties;
import lombok.extern.slf4j.Slf4j;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonHystrixCommondCircuitClose
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 14:24
 * @Version 1.0
 * @DESCRIPTION: 断路器关闭
 * <p>
 * 断路器有三个状态 ：OPEN、 CLOSED（默认状态） 、HALF_OPEN状态
 * 当断路器打开后，对应接口的请求会有段休眠期，这个休眠期内接口请求不会被正真的执行，但是如果休眠期时间过了，
 * 这个时候断路器的状态就到了HALF_OPEN状态，这个时候断路器允许一次真实的接口请求，如果这次请求失败，则断路
 * 器打开OPEN，循环上面的动作，如果请求成功则断路器关CLOSED。
 * <p>
 * 设置一个变量，初始化为true,并且在run()方法中我们将根据传入的值设置时间，先让其超时，开启断路器，然后休眠6秒后，
 * 调用的时间减少值不超时。断路器关闭，并且10内满足3个请求就会触发断路器第一个条件。
 **/
@Slf4j
public class LeonHystrixCommondCircuitClose {
    public static void main(String[] args) throws InterruptedException {
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.circuitBreaker.requestVolumeThreshold", 3);
        boolean isTimeout = true;
        for (int i = 0; i < 10; i++) {
            TestCommand c = new TestCommand(isTimeout);
            c.execute();

            HystrixCommandMetrics.HealthCounts hc = c.getMetrics().getHealthCounts();
            System.out.println("健康信息:" + hc.getTotalRequests());
            if (c.isCircuitBreakerOpen()) {
                isTimeout = false;
                log.info("断路器打开了，第{}索引，等待休眠期结束", i);
                log.info("休眠6秒");
                Thread.sleep(6000);
            }
        }
    }

    static class TestCommand extends HystrixCommand<String> {
        private boolean isTimeout;

        public TestCommand(boolean isTimeout) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(500)));
            this.isTimeout = isTimeout;
        }

        protected String run() throws InterruptedException {
            if (isTimeout) {
                Thread.sleep(800);
            } else {
                Thread.sleep(200);
            }
            return "";
        }

        protected String getFallback() {
            return "fallback";
        }
    }
}
