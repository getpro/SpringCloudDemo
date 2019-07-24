package com.irskj.cloud.rmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

/**
 * Created by irskj on 2019/1/11.
 */
@Slf4j
@EnableBinding(LoginSendBinder.class)
public class LoginSender {

    @Bean
    @InboundChannelAdapter(value = LoginSendBinder.NAME, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<String> timerMessageSource() {
        return new MessageSource<String>() {
            @Override
            public Message<String> receive() {
                StringBuilder msg = new StringBuilder();
                msg.append("测试消息：");
                msg.append(System.currentTimeMillis());
                return new GenericMessage<String>(msg.toString());
            }
        };
    }
}
