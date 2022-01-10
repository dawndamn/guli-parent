package com.atguigu.controller;

import com.atguigu.service.VodService;
import com.atguigu.utils.R;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("/eduvod/video")
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    @PostMapping("upoadVideoAly")
    public R upoadVideoAly(MultipartFile file){
        String vodId = vodService.upoadVideoAly(file);
        return R.ok().data("vodId",vodId);

    }

    @PostMapping("removeVideoAly/{id}")
    public R removeVideo(@PathVariable String id){
        vodService.removeVideo(id);
        return R.ok();
    }

    /**
     * 批量删除视频
     * @param videoIdList
     * @return
     */
    @DeleteMapping("delete-batch")
    public R removeVideoList(
            @ApiParam(name = "videoIdList", value = "云端视频id", required = true)
            @RequestParam("videoIdList") List<String> videoIdList){

        vodService.removeVideoList(videoIdList);
        return R.ok().message("视频删除成功");
    }
}
