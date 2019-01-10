package com.irskj.cloud;

import com.irskj.cloud.service.DemoApiService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by irskj on 2019/1/10.
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FeignUploadTester {
    @Autowired
    DemoApiService demoApiService;

    @Test
    @SneakyThrows
    public void testUpload(){
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
        log.info("############# 上传文件成功：{} ###############",result);
    }
}
