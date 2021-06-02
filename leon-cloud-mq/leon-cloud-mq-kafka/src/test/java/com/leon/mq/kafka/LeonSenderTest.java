package com.leon.mq.kafka;

import com.leon.mq.kafka.sender.LeonSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: LeonSenderTest
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/6/2 14:51
 * @Version 1.0
 * @DESCRIPTION: 测试用例
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LeonSenderTest {
    @Autowired
    private LeonSender leonSender;

    @Test
    public void send() {
        for (int i = 0; i < 10; i++) {
            leonSender.send();
        }
    }
}
