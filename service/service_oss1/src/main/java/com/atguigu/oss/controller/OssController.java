package com.atguigu.oss.controller;

import com.atguigu.oss.service.OssService;
import com.atguigu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    @PostMapping
    public R uploadOssFile(@RequestParam("file") MultipartFile multipartFile){

        String url = ossService.uploadFileAvatar(multipartFile);
        return R.ok().data("url",url);
    }
}
