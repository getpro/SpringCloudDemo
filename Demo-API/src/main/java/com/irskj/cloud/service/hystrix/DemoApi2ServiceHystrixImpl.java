package com.irskj.cloud.service.hystrix;

import com.irskj.cloud.service.DemoApi2Service;

/**
 * Created by irskj on 2019/1/11.
 */
public class DemoApi2ServiceHystrixImpl implements DemoApi2Service {
    @Override
    public String hello() {
        return "demoapi2 Error";
    }
}
