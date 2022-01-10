package com.atguigu.serviceedu.controller;


import com.atguigu.servicebase.config.exceptionHandler.AutoGuliException;
import com.atguigu.serviceedu.client.VodClient;
import com.atguigu.serviceedu.entity.EduVideo;
import com.atguigu.serviceedu.service.EduVideoService;
import com.atguigu.utils.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-03-23
 */
@RestController
@RequestMapping("/serviceedu/video")
@CrossOrigin
public class EduVideoController {
    @Autowired
    private EduVideoService eduVideoService;

    @Autowired
    private VodClient vodClient;

    //增加小节
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
        eduVideoService.save(eduVideo);
        return R.ok();
    }

    //删除小节
    @PostMapping("{id}")
    public R deleteVideo(@PathVariable String id){
        //查询云端视频id
        EduVideo video = eduVideoService.getById(id);
        String videoSourceId = video.getVideoSourceId();
        //删除视频资源
        if(!StringUtils.isEmpty(videoSourceId)){
            R r = vodClient.removeVideo(videoSourceId);
            if (r.getCode()==20001){
                throw new AutoGuliException(20001,"错误");
            }
        }
        eduVideoService.removeById(id);
        return R.ok();
    }
    //修改小节
}

