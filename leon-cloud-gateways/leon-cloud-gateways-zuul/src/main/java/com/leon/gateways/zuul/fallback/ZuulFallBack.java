package com.leon.gateways.zuul.fallback;

import cn.hutool.json.JSONUtil;
import com.leon.common.LeonResult;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: ZuulFallBack
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/2 13:48
 * @Version 1.0
 * @DESCRIPTION: 扩展 {@link FallbackProvider}
 * <p>
 * getRoute 方法中返回*表示对所有服务进行回退操作，如果只想对某个服务进行回退，
 * 那么就返回需要回退的服务名称，这个名称是注册到Eureka中的名称
 *
 * ClientHttpResponse 构造回退的内容
 *
 * getStatusCode 返回响应的状态码
 *
 * getStatusText 返回响应状态码对应的文本
 *
 * getBody 返回回退的内容
 *
 * getHeaders 返回响应的请求头信息
 **/
@Slf4j
@Configuration
public class ZuulFallBack implements FallbackProvider {

    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                RequestContext ctx = RequestContext.getCurrentContext();
                Throwable throwable = ctx.getThrowable();
                if (null != throwable) {
                    log.error("Zuul发生错误,{}", throwable.getCause().getMessage());
                    LeonResult<String> byteMsg = LeonResult.failed(throwable.getCause().getMessage(), "网络或服务异常");
                    return new ByteArrayInputStream(JSONUtil.toJsonStr(byteMsg).getBytes());
                }
                LeonResult<String> byteMsg = LeonResult.failedMsg("网络或服务异常");
                return new ByteArrayInputStream(JSONUtil.toJsonStr(byteMsg).getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mediaType = new MediaType("application", "json", StandardCharsets.UTF_8);
                headers.setContentType(mediaType);
                return headers;
            }
        };
    }
}

