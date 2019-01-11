package com.irskj.cloud.service;

import com.irskj.cloud.service.hystrix.DemoApi2ServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by irskj on 2019/1/11.
 */
@FeignClient(value = "api-gateway",fallback = DemoApi2ServiceHystrixImpl.class,path = "/v1/demoapi2")
public interface DemoApi2Service {

    @GetMapping("/hello")
    String hello();
}
