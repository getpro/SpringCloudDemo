package com.irskj.cloud.dubbo.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.irskj.cloud.dubbo.model.R;
import com.irskj.cloud.dubbo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class OrderController {
    @Reference
    private UserService userService;

    @GetMapping("/user")
    public R index(){
        return R.success(userService.getUser());
    }

    @PostMapping("/upload")
    public R upload(MultipartFile file) throws IOException {
        return R.success(userService.upload(file.getBytes()));
    }

}
