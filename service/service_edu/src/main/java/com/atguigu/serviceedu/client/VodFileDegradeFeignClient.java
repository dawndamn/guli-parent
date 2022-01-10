package com.atguigu.serviceedu.client;

import com.atguigu.utils.R;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VodFileDegradeFeignClient implements VodClient {
    @Override
    public R removeVideo(String id) {
        return R.erro().message("删除视频出错");
    }

    @Override
    public R removeVideoList(List<String> videoIdList) {
        return R.erro().message("删除视频出错");
    }
}
