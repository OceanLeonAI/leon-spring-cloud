package com.leon.gateways.gateway.dynamic.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonGlobalFilter
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/3 10:38
 * @Version 1.0
 * @DESCRIPTION:
 **/
@Configuration
public class LeonGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        URI uri = request.getURI();
        System.out.println("uri" + uri);
        System.out.println(exchange);
        System.out.println(chain);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
