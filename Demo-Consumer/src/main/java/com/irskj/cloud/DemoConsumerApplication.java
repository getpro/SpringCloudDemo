package com.irskj.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@EnableTurbine
@EnableCircuitBreaker
@SpringBootApplication
public class DemoConsumerApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoConsumerApplication.class, args);
    }

}

