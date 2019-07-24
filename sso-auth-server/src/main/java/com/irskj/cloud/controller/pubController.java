package com.irskj.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by irskj on 2019/1/16.
 */
@RestController
@RequestMapping("/api/public")
public class pubController {

    @GetMapping("/test")
    public String test() {
        return "public api";
    }
}
