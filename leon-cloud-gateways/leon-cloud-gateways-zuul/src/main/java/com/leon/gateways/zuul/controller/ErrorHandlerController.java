package com.leon.gateways.zuul.controller;

import cn.hutool.core.util.StrUtil;
import com.leon.common.LeonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: ErrorHandlerController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/2 10:49
 * @Version 1.0
 * @DESCRIPTION: 测试异常捕获用 controller
 **/
@RestController
public class ErrorHandlerController implements ErrorController {
    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public LeonResult error(HttpServletRequest request) {
        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(new ServletWebRequest(request), true);
        String message = (String) errorAttributes.get("message");
        String trace = (String) errorAttributes.get("trace");
        if (StrUtil.isNotBlank(trace)) {
            message = message + ",trace is " + trace;
        }
        return LeonResult.failed(message);
    }
}
