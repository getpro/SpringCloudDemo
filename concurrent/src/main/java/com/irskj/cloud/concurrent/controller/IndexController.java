package com.irskj.cloud.concurrent.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Log4j2
@RestController
public class IndexController {

    private ExecutorService executorService = Executors.newCachedThreadPool();


    //异步返回
    @GetMapping("/index")
    public Callable<String> index(){
        log.info("Callable主线程开始....");

        Callable callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("Callable子线程开始....");
                Thread.sleep(2000);
                log.info("Callable主线程结束....");

                return "ok";
            }
        };

        log.info("Callable主线程结束....");

        return callable;
    }

    @GetMapping("/async")
    public DeferredResult<Object> index2(){
        log.info("DeferredResult主线程开始....");
        DeferredResult<Object> result = new DeferredResult<>();

        result.setResultHandler(new DeferredResult.DeferredResultHandler() {
            @Override
            public void handleResult(Object result) {
                log.info("DeferredResult异步结果："+result.toString());
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                log.info("DeferredResult子线程开始....");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result.setResult("async ok");
                log.info("DeferredResult子线程结束....");
            }
        });

        log.info("DeferredResult主线程结束....");
        return result;
    }
}
