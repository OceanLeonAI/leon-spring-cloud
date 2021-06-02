package com.leon.gateways.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: ErrorFilter
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/2 10:41
 * @Version 1.0
 * @DESCRIPTION: 异常捕获 Filter
 **/
@Slf4j
public class ErrorFilter extends ZuulFilter {

    /**
     * 过滤器类型，pre 、route 、post 、error
     *
     * @return
     * @see ZuulFilter#filterType()
     */
    @Override
    public String filterType() {
        return "error";
    }

    /**
     * 过滤器的执行顺序，数值越小，优先级越高。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 是否执行该过滤器， true 为执行， false 为不执行，可以结合配置中心及结合业务逻辑设置
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 执行自己的业务逻辑。
     * 设置的ctx.setSendZuulResponse(false);
     * 代表不对其进行路由，ctx.setSendZuulResponse(true);表示对请求进行路由。
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        ctx.setSendZuulResponse(false); //不对其进行路由
        ctx.setResponseStatusCode(401);
        HttpServletResponse response = ctx.getResponse();
        response.setHeader("content-type", "text/html;charset=utf8");
        ctx.setResponseBody("认证失败" + throwable.getCause().getMessage());
        ctx.set("code", 500);
        log.error("异常信息,{}", throwable.getCause().getMessage());
        return null;
    }
}
