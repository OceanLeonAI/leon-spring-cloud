package com.leon.mq.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonReceiver
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/2 14:49
 * @Version 1.0
 * @DESCRIPTION: 消息接收方
 **/
@Slf4j
@Component
public class LeonReceiver {

    /**
     * @param message
     */
    @KafkaListener(topics = "leoncloud")
    public void onMessage(String message) {
        log.info(message);
    }
}
