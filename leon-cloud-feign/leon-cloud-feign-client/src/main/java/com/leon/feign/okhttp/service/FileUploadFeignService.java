package com.leon.feign.okhttp.service;

/**
 * @PROJECT_NAME: leon-spring-cloud
 * @CLASS_NAME: FileUploadFeignService
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021-05-31 22:20
 * @DESCRIPTION: 文件上传
 **/

import com.leon.feign.okhttp.config.FeignMultipartSupportConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @RequestPart与@RequestParam的区别：
 * @RequestPart这个注解用在multipart/form-data表单提交请求的方法上。
 * @RequestPart支持的请求方法的方式MultipartFile，属于Spring的MultipartResolver类。这个请求是通过http协议传输的。
 * @RequestParam也同样支持multipart/form-data请求。 他们最大的不同是，当请求方法的请求参数类型不再是String类型的时候。
 * @RequestParam适用于name-valueString类型的请求域， @RequestPart适用于复杂的请求域（像JSON，XML
 */
@FeignClient(value = "leon-cloud-upload", configuration = FeignMultipartSupportConfiguration.class)
public interface FileUploadFeignService {
    /***
     * 1.produces,consumes必填
     * 2.注意区分@RequestPart和RequestParam，不要将
     * : @RequestPart(value = "file") 写成@RequestParam(value = "file")
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadFile(@RequestPart(value = "file") MultipartFile file);
}
