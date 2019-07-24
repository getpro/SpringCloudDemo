package com.irskj.cloud.rmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by irskj on 2019/1/11.
 */
@Slf4j
@EnableBinding(LoginBinder.class)
public class SinkReceiver {

    @StreamListener(LoginBinder.name)
    public void receive(String payload) {

        log.info("Consumer1：{}", payload);
    }
}
