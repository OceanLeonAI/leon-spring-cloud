package com.leon.feign.okhttp.service;

import com.leon.feign.okhttp.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: EurekaFeignService
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/31 15:43
 * @Version 1.0
 * @DESCRIPTION: 定义Feign 请求的接口
 * <p>
 * 注意事项：
 * 1.如果你在项目里面设置了同意的请求路径(server.servlet.context-path),需要将@FeignClient注解调整@FeignClient(value = "fw-register-eureka-client",path = "xxx")
 * 2.Feign 里面定义的接口，有多个@RequestParam，但只能有不超过一个@RequestBody
 * 3.在定义接口的时候，如果返回的是用户自定义的实体，建议抽取出来，在Controller中实现接口，将抽取出来的接口单独打包，需要调用的项目依赖此包即可，每个项目不用重新定义一遍
 **/
@FeignClient(value = "leon-register-eureka-client", configuration = FeignConfig.class) // 里面配置的value 就是服务的名称
public interface EurekaFeignService {
    //feign中你可以有多个@RequestParam，但只能有不超过一个@RequestBody
    @GetMapping("/hello")
    String hello();
}
