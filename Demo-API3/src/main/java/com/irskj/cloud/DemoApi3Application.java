package com.irskj.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.SamplerProperties;

@EnableDiscoveryClient
@SpringBootApplication
public class DemoApi3Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoApi3Application.class, args);
	}

}

