package com.leon.hystrix.ribbon.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: HystrixFilter
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/1 14:51
 * @Version 1.0
 * @DESCRIPTION: hystrix 缓存过滤器
 **/
@WebFilter(urlPatterns = "/*", filterName = "hystrixFilter")
@Component
public class HystrixFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            context.shutdown();
        }
    }
}
