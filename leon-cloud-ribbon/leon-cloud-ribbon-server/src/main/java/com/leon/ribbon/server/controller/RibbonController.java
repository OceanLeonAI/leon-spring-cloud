package com.leon.ribbon.server.controller;

import com.leon.ribbon.server.entity.User;
import com.leon.ribbon.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: RibbonController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021-05-30 22:40
 * @DESCRIPTION: ribbon demo接口演示
 **/
@Slf4j
@RestController
@RequestMapping("user")
public class RibbonController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id:\\d+}")
    public User getUserById(@PathVariable Long id, HttpServletRequest req) throws InterruptedException {

        // ================= 超过500秒就会重试 begin =================
//        int millis = new Random().nextInt(3000);
//        System.out.println("client线程休眠时间：" + millis);
//        Thread.sleep(millis);
        // ================= 超过500秒就会重试   end =================

        String url = req.getRequestURL().toString();
        User user = userService.getUserById(id);
        user.setRemark(user.getRemark() + ":提供服务的是:" + url);
        return user;
    }

    @GetMapping("/list")
    public List<User> getUserById(String ids, HttpServletRequest req) {
        log.info("ids,{}", ids);
        List<User> list = new ArrayList<>();
        String[] splitIds = ids.split(",");
        for (String id : splitIds) {
            String url = req.getRequestURL().toString();
            User user = userService.getUserById(Long.valueOf(id));
            user.setRemark(user.getRemark() + ":提供服务的是:" + url);
            list.add(user);
        }
        return list;
    }
}
