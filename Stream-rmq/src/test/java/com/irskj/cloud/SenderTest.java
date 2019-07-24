package com.irskj.cloud;

import com.irskj.cloud.rmq.LoginSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by irskj on 2019/1/11.
 */
@RunWith(SpringRunner.class)
@EnableBinding(value = {LoginSender.class})
public class SenderTest {
    @Autowired
    private LoginSender loginSender;

    @Test
    public void sinkSenderTest() {
        loginSender.output().send(MessageBuilder.withPayload("测试消息").build());
    }
}
