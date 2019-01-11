package com.irskj.cloud.rmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by irskj on 2019/1/11.
 */
public interface SinkSender {
    String OUTPUT="input";

    @Output(SinkSender.OUTPUT)
    MessageChannel output();
}
