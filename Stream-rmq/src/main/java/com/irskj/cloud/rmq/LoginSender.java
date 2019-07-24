package com.irskj.cloud.rmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by irskj on 2019/1/11.
 */
public interface LoginSender {
    String name = "login-topic";

    @Output(name)
    MessageChannel output();
}
