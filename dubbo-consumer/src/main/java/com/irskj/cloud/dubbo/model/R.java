package com.irskj.cloud.dubbo.model;

import lombok.Data;

@Data
public class R {
    private int code;
    private String msg;
    private Object data;

    public R(Object data) {
        this.data = data;
        this.code =200;
        this.msg = "success";
    }

    public static R success(Object data){
        return new R(data);
    }
}
