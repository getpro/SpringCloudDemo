package com.irskj.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by irskj on 2019/1/11.
 */
@Slf4j
@RestController
public class IndexController {

    @GetMapping("/hello")
    public String hello() {
        log.info("call demoapi2:hello");
        return "demoapi2：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }
}
