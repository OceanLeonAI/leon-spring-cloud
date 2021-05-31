package com.leon.feign.without.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: User
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021-05-31 22:52
 * @DESCRIPTION: 用户
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -4345907979346230638L;

    /**
     * 主键
     */
    private long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String remark;
}
