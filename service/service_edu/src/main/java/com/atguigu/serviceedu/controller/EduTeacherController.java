package com.atguigu.serviceedu.controller;


import com.atguigu.servicebase.config.exceptionHandler.AutoGuliException;
import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.entity.vo.TeacherQuery;
import com.atguigu.serviceedu.service.EduTeacherService;
import com.atguigu.serviceedu.service.impl.EduTeacherServiceImpl;
import com.atguigu.utils.R;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-01-24
 */
@RestController
@RequestMapping("/serviceedu/teacher")
@CrossOrigin
public class EduTeacherController {
    @Autowired
    EduTeacherService eduTeacherService = new EduTeacherServiceImpl();

    @GetMapping("findAllTeacher")
    public R findAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list(null);
        /*try {
            int i = 1/0;
        }catch (Exception e){
            throw new AutoGuliException(20001,"自定义异常抛出");
        }*/
        return R.ok().data("list",list);
    }

    @DeleteMapping("{id}")
    public R removeById(@PathVariable String id){
        boolean b = eduTeacherService.removeById(id);
        if (b){
            return R.ok();
        }else {
            return R.erro();
        }
    }

    @GetMapping("teacherPage/{curent}/{size}")
    public R page(@PathVariable Long curent,@PathVariable Long size){
        Page<EduTeacher> page = new Page(curent,size);
        eduTeacherService.page(page,null);
        long total = page.getTotal();
        List<EduTeacher> records = page.getRecords();
        return R.ok().data("total:",total).data("rows:",records);
    }

    @PostMapping("teacherPageQuery/{curent}/{size}")
    public R pageQuery(@PathVariable Long curent, @PathVariable Long size, @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<EduTeacher> page = new Page(curent,size);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper();
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if (!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if (!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if (!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if (!StringUtils.isEmpty(end)){
            wrapper.le("gmt_modified",end);
        }
        wrapper.orderByDesc("gmt_create");
        eduTeacherService.page(page,wrapper);
        long total = page.getTotal();
        List<EduTeacher> records = page.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }

    //添加讲师
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if (save){
            return R.ok();
        }else {
            return R.erro();
        }
    }

    //讲师查询
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id){
        EduTeacher teacher = eduTeacherService.getById(id);
        if (teacher!=null){
            return R.ok().data("teacher",teacher);
        }else {
            return R.erro();
        }
    }

    //讲师修改
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean b = eduTeacherService.updateById(eduTeacher);
        if (b){
            return R.ok();
        }else {
            return R.erro();
        }
    }
}

