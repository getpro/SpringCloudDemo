package com.irskj.cloud.rmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by irskj on 2019/1/11.
 */
public interface LoginSendBinder {
    String NAME = "login-topic";

    @Output(NAME)
    MessageChannel output();
}
