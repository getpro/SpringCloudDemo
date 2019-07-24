package com.irskj.cloud.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.irskj.cloud.dubbo.service.UserService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUser() {
        log.info("调用用户服务");
        return "user"+System.currentTimeMillis();
    }
}
