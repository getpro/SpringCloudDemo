package com.irskj.cloud.controller;

import com.irskj.cloud.utils.SecurityUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by irskj on 2019/1/16.
 */
@RestController
@RequestMapping("/api")
public class IndexController {

    @GetMapping("/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public String hello(){

        return "hello："+ SecurityUtils.getCurrentUser();
    }
}
