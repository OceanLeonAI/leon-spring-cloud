package com.leon.client.eureka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: User
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/5/27 14:43
 * @Version 1.0
 * @DESCRIPTION: User 实体类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @Data 是lombok提供的默认getter setter 注解
 * @AllArgsConstructor 全部参数的有参构造函数注解
 * @NoArgsConstructor 无参构造函数注解
 */
public class User implements Serializable {
    private static final long serialVersionUID = 3943538698981874876L;
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
