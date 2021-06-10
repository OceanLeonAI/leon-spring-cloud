package com.leon.client.nacos.official.sdk;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: NacosJavaSDKTest
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/3 14:12
 * @Version 1.0
 * @DESCRIPTION:
 **/
public class NacosJavaSDKTest {
    private static String serverAddr = "localhost:8848";
//    private static String dataId = "leon-cloud-nacos-register";
    private static String dataId = "leon-register-nacos-configuration.yaml";
    private static String group = "DEFAULT_GROUP";

    public static void main(String[] args) {
        getConfig();
    }

    /**
     * 用于服务启动的时候从 Nacos 获取配置。
     */
    private static void getConfig() {
        try {
//            String serverAddr = "{serverAddr}";
            serverAddr = serverAddr;
//            String dataId = "{dataId}";
            dataId = dataId;
//            String group = "{group}";
            group = "{group}";
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(dataId, group, 5000);
            System.out.println(content);
        } catch (NacosException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
