package com.irskj.cloud;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableSwagger2Doc
@EnableDiscoveryClient
@SpringBootApplication
public class DemoApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoApi2Application.class, args);
	}

}

