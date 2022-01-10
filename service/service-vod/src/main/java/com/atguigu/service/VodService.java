package com.atguigu.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface VodService {

    String upoadVideoAly(MultipartFile file);

    void removeVideo(String id);

    void removeVideoList(List videoIdList);
}
