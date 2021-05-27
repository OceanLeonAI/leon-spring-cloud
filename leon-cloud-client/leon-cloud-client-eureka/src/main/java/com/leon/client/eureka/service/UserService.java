package com.leon.client.eureka.service;

import com.leon.client.eureka.entity.User;

import java.util.List;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: UserService
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/27 14:51
 * @Version 1.0
 * @DESCRIPTION: 用户 Service
 **/
public interface UserService {
    /**
     * 模拟数据库获取所有用户
     *
     * @return
     */
    List<User> getUsers();

    /**
     * 模拟数据库根据id获取用户
     *
     * @return
     */
    User getUserById(long id);
}
