package com.irskj.cloud.rmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by irskj on 2019/1/11.
 */
public interface LoginBinder {
    String name = "login-topic";

    @Input(name)
    SubscribableChannel input();
}
