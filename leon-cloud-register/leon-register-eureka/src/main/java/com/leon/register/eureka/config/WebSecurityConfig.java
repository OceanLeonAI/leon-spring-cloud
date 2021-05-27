package com.leon.register.eureka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: WebSecurityConfig
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/27 15:29
 * @Version 1.0
 * @DESCRIPTION: 扩展 {@link WebSecurityConfigurerAdapter}
 * 主要是因为高版本丢弃了security. basic.enabled= true配置，
 * 并且需要注意需要设置httpBasic()，
 * 否则不支持http://${user}:${password}@${host}:${port}/eureka/ 这种方式登录
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("=====================================进入过滤=====================================");
        http.httpBasic().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and().authorizeRequests().anyRequest().authenticated()
                .and().csrf().disable();
    }
}
