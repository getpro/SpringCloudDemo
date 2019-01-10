package com.irskj.cloud.service.hystrix;

import com.irskj.cloud.service.DemoApiService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by irskj on 2019/1/10.
 */
@Component
public class DemoApiServiceHystrixImpl implements DemoApiService {


    @Override
    public String hello(String accessToken) {
        return "Error";
    }

    @Override
    public String upload(MultipartFile file) {
        return null;
    }
}
