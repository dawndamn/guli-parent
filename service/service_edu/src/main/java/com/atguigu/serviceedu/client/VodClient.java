package com.atguigu.serviceedu.client;

import com.atguigu.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name="service-vod",fallback = VodFileDegradeFeignClient.class)
public interface VodClient {

    @PostMapping("/eduvod/video/removeVideoAly/{id}")
    public R removeVideo(@PathVariable("id") String id);

    @DeleteMapping(value = "/eduvod/video/delete-batch")
    public R removeVideoList(@RequestParam("videoIdList") List<String> videoIdList);
}
