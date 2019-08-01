package com.irskj.cloud.dubbo.service;

import java.io.InputStream;

public interface UserService {

    String getUser();

    String upload(byte[] in);
}
