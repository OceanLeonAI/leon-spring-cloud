package com.leon.mq.kafka.sender;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonSender
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/2 14:47
 * @Version 1.0
 * @DESCRIPTION: kafka 消息发送方
 **/
@Component
@Slf4j
public class LeonSender {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public boolean send() {
        String message = "Hello World:" + DateUtil.now();
        log.info("LeonSender:" + message);
        //第一个参数是topic，第二个参数是内容
        kafkaTemplate.send("leoncloud", message);
        return true;
    }
}
