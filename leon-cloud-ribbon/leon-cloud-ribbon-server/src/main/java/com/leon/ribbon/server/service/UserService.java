package com.leon.ribbon.server.service;

import com.leon.ribbon.server.entity.User;

import java.util.List;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: UserService
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021-05-30 22:37
 * @DESCRIPTION:
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
