package com.atguigu.serviceedu.controller;


import com.atguigu.serviceedu.entity.subject.OneSubject;
import com.atguigu.serviceedu.service.EduSubjectService;
import com.atguigu.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-02-23
 */
@RestController
@RequestMapping("/serviceedu/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    EduSubjectService eduSubjectService;

    @PostMapping("addSubject")
    public R addSubject(@RequestParam("file") MultipartFile multipartFile){

        eduSubjectService.saveSubject(multipartFile,eduSubjectService);
        return R.ok();
    }

    //查询所有一二级分类
    @GetMapping("getAllSubject")
    public R getAllSubject(){
        List<OneSubject> oneSubjectList = eduSubjectService.findOneAndTowSubject();
        return R.ok().data("subject",oneSubjectList);
    }

}

