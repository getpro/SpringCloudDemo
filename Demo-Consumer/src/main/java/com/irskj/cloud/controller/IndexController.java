package com.irskj.cloud.controller;

import com.irskj.cloud.service.DemoApiService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

/**
 * Created by irskj on 2019/1/9.
 */
@RestController
@RefreshScope
public class IndexController extends BaseAbstractController{

    @Autowired
    private DemoApiService demoApiService;

    @Value("${info.profile}")
    private Object info;

    /**
     * 远程服务
     * @return
     */
    @GetMapping("/hello")
    public String hello(String accessToken){
        return demoApiService.hello(accessToken);
    }

    /**
     * 远程配置
     * @return
     */
    @GetMapping("/info")
    public Object info(){
        return info;
    }

    /**
     * 远程服务上传
     * @return
     * @throws IOException
     */
    @GetMapping("/upload")
    public String upload() throws IOException {
        File file = new File("test.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().
                createItem("file", MediaType.TEXT_PLAIN_VALUE,true,file.getName());
        try (InputStream inputStream = new FileInputStream(file); OutputStream outputStream=fileItem.getOutputStream()){
            IOUtils.copy(inputStream,outputStream);
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid File："+e,e);
        }
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        String result = demoApiService.upload(multipartFile);
        if(result==null){
            result = "失败";
        }
        logger.info("############# 上传文件成功：{} ###############",result);
        return result;
    }


}
