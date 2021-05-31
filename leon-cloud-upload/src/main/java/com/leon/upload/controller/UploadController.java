package com.leon.upload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: UploadController
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021-05-31 21:55
 * @DESCRIPTION:
 **/
@RestController
@Slf4j
public class UploadController {
    @PostMapping(value = "/uploadFile")
    public String uploadFile(MultipartFile file) throws Exception {
        log.info("upload file name : {}", file.getName());
        //上传文件
        file.transferTo(new File("E:/leon-spring-cloud/" + file.getOriginalFilename()));
        return file.getOriginalFilename();
    }
}
