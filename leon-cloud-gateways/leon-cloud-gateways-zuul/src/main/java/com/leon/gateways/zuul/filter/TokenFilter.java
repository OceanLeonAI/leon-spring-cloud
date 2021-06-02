package com.leon.gateways.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: TokenFilter
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/2 9:49
 * @Version 1.0
 * @DESCRIPTION: 过滤器
 **/
@Slf4j
public class TokenFilter extends ZuulFilter {
    /**
     * 过滤器类型，pre 、route 、post 、error
     *
     * @return
     */
    @Override
    public String filterType() {
        System.out.println("com.leon.gateways.zuul.filter.TokenFilter.filterType() called...");
        return "pre"; // 在请求被路由之前调用
    }

    /**
     * 过滤器的执行顺序，数值越小，优先级越高。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0; // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
    }

    /**
     * 是否执行该过滤器， true 为执行， false 为不执行，可以结合配置中心及结合业务逻辑设置
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true; // 是否执行该过滤器，此处为true，说明需要过滤
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
        // 手动创造异常
//        int i = 10 / 0;

        RequestContext ctx = RequestContext.getCurrentContext();
        log.info("我是 TokenFilter");
        HttpServletRequest request = ctx.getRequest();

        String token = request.getHeader("token");// 获取请求的参数

        // 如果有token参数并且token值为123456，才进行路由
        if (StringUtils.isNotBlank(token) && token.equals("123456")) {
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("code", 1);
        } else {
            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(401);
            HttpServletResponse response = ctx.getResponse();
            response.setHeader("content-type", "text/html;charset=utf8");
            ctx.setResponseBody("认证失败");
            ctx.set("code", 0);
            // 验证失败以后通知后续不执行
            ctx.set("isShould", false);
        }
        return null;
    }
}
