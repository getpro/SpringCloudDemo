package com.irskj.cloud.controller;

import com.irskj.cloud.service.DemoApi2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by irskj on 2019/1/9.
 */
@RestController
public class IndexController extends BaseAbstractController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private Registration registration;
    @Autowired
    private DemoApi2Service demoApi2Service;
    @Value("${hello}")
    private String hello;


    @GetMapping("/hello")
    public String hello(String accessToken) {
        return "demoapi call：" + demoApi2Service.hello();
    }

    @PostMapping("/upload")
    public String upload(@RequestPart(value = "file") MultipartFile file) {
        logger.info("######### 上传文件:{} ###############", file.getOriginalFilename());
        return file.getOriginalFilename();
    }


    /**
     * 获取当前服务的服务实例
     *
     * @return ServiceInstance
     */
    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = discoveryClient.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

}
