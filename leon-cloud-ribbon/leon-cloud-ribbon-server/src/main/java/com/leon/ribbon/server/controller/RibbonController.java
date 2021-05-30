package com.leon.ribbon.server.controller;

import com.leon.ribbon.server.entity.User;
import com.leon.ribbon.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: RibbonController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021-05-30 22:40
 * @DESCRIPTION: ribbon demo接口演示
 **/
@RestController
@RequestMapping("user")
public class RibbonController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id:\\d+}")
    public User getUserById(@PathVariable Long id, HttpServletRequest req) {
        String url = req.getRequestURL().toString();
        User user = userService.getUserById(id);
        user.setRemark(user.getRemark() + ":提供服务的是:" + url);
        return user;
    }
}
