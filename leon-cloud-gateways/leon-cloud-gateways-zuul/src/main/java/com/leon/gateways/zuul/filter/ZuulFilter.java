package com.leon.gateways.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: ZuulFilter
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/2 10:01
 * @Version 1.0
 * @DESCRIPTION: 新建一个过滤器，设置执行顺序为5，在TokenFilter之后，
 * 待会可以验证一下，
 * 这个过滤器是验证header中是否有name这个key，
 * 并且key的值要是zuul才能通过，否则失败。
 **/
@Slf4j
public class ZuulFilter extends com.netflix.zuul.ZuulFilter {
    /**
     * 过滤器类型，pre 、route 、post 、error
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }


    /**
     * 过滤器的执行顺序，数值越小，优先级越高。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 5; // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
    }

    /**
     * 是否执行该过滤器， true 为执行， false 为不执行，可以结合配置中心及结合业务逻辑设置
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        // 从上下文中获取是否执行该过滤器的标志
        RequestContext currentContext = RequestContext.getCurrentContext();
        Boolean isShould = (Boolean) currentContext.get("isShould");
        return null == isShould; // 是否执行该过滤器，此处为true，说明需要过滤
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
        // 获取当前上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        log.info("我是 ZuulFilter");
        // 获取 HttpServletRequest 对象
        HttpServletRequest request = currentContext.getRequest();
        // 获取请求参数
        String name = request.getHeader("name");

        // 如果有name参数并且token值为zuul，才进行路由
        if (StringUtils.isNotBlank(name) && name.equals("zuul")) {
            currentContext.setSendZuulResponse(true); //对请求进行路由
            currentContext.setResponseStatusCode(200);
            currentContext.set("code", 1);
        } else {
            currentContext.setSendZuulResponse(false); //不对其进行路由
            currentContext.setResponseStatusCode(401);
            HttpServletResponse response = currentContext.getResponse();
            response.setHeader("content-type", "text/html;charset=utf8");
            currentContext.setResponseBody("请携带网关必须参数");
            currentContext.set("code", 0);
        }
        return null;
    }
}
