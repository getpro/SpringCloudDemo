package com.irskj.cloud.service;

import com.irskj.cloud.service.hystrix.DemoApiServiceHystrixImpl;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by irskj on 2019/1/10.
 */
@FeignClient(value = "api-gateway",fallback = DemoApiServiceHystrixImpl.class,configuration = DemoApiService.MultipartSupportConfig.class,path = "/v1/demoapi")
public interface DemoApiService {

    @GetMapping("/hello")
    String hello(@RequestParam("accessToken") String accessToken);

    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart(value = "file") MultipartFile file);

    @Configuration
    class MultipartSupportConfig{

        @Bean
        public Encoder feignFormEncoder(){
            return new SpringFormEncoder();
        }
    }

}
