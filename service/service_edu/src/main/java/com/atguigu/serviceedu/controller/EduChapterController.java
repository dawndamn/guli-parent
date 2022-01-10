package com.atguigu.serviceedu.controller;


import com.atguigu.serviceedu.entity.EduChapter;
import com.atguigu.serviceedu.entity.chapter.ChapterVo;
import com.atguigu.serviceedu.service.EduChapterService;
import com.atguigu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-03-23
 */
@RestController
@RequestMapping("/serviceedu/chapter")
@CrossOrigin
public class EduChapterController {

    @Autowired
    private EduChapterService eduChapterService;

    @GetMapping("/getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable(value = "courseId") String courseId){

        List<ChapterVo> eduChapterList =  eduChapterService.getChapterVideo(courseId);
        return R.ok().data("chapterAndVideo",eduChapterList);
    }

    @PostMapping("/addChapter")
    public R addChapter(@RequestBody EduChapter eduChapter){
        eduChapterService.addChapter(eduChapter);
        return R.ok();
    }

    @PostMapping("/deleteChapter/{chapterId}")
    public R deleteChapter(@PathVariable String chapterId){
        boolean result = eduChapterService.deleteChapter(chapterId);
        if(result){
            return R.ok();
        }else {
            return R.erro();
        }
    }

    @PostMapping("updateChapter")
    public R updateChapter(@RequestBody EduChapter eduChapter){
        eduChapterService.updateChapter(eduChapter);
        return R.ok();
    }

    @GetMapping("selectChapter/{chapterId}")
    public R selectChapter(@PathVariable String chapterId){
        EduChapter eduChapter = eduChapterService.selectChapter(chapterId);
        return R.ok().data("chapter",eduChapter);
    }
}

