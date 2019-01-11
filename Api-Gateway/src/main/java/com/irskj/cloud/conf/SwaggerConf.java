package com.irskj.cloud.conf;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irskj on 2019/1/10.
 */
@Component
@Primary
public class SwaggerConf implements SwaggerResourcesProvider{


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        //name自定义，location分两部分/v1/demoapi 为api网关配置，/v2/api-docs为实际项目路径
        resources.add(swaggerResource("Demo-API","/v1/demoapi/v2/api-docs","2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name,String location,String version){
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
