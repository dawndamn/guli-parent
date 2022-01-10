package com.atguigu.serviceedu.service.impl;

import com.atguigu.servicebase.config.exceptionHandler.AutoGuliException;
import com.atguigu.serviceedu.entity.EduCourse;
import com.atguigu.serviceedu.entity.EduCourseDescription;
import com.atguigu.serviceedu.entity.vo.CourseInfoForm;
import com.atguigu.serviceedu.entity.vo.CoursePublishVo;
import com.atguigu.serviceedu.mapper.EduCourseMapper;
import com.atguigu.serviceedu.service.EduChapterService;
import com.atguigu.serviceedu.service.EduCourseDescriptionService;
import com.atguigu.serviceedu.service.EduCourseService;
import com.atguigu.serviceedu.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-03-23
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService eduCourseDescriptionService;

    @Autowired
    private EduCourseMapper eduCourseMapper;

    @Autowired
    private EduVideoService eduVideoService;

    @Autowired
    private EduChapterService eduChapterService;



    @Override
    public String saveCourseInfo(CourseInfoForm courseInfoForm) {
        //向课程表中添加信息
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoForm,eduCourse);
        int insert = baseMapper.insert(eduCourse);
        if (insert==0){
            throw new AutoGuliException(20001,"添加课程失败");
        }

        //获取id
        String id = eduCourse.getId();

        //向简介表中添加信息
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setDescription(courseInfoForm.getDescription());
        eduCourseDescription.setId(id);
        eduCourseDescriptionService.save(eduCourseDescription);

        return id;
    }

    @Override
    public CourseInfoForm getCourseInfo(String id) {
        CourseInfoForm courseInfoForm = new CourseInfoForm();

        //查询课程
        EduCourse eduCourse = baseMapper.selectById(id);
        BeanUtils.copyProperties(eduCourse,courseInfoForm);

        //查询详情
        EduCourseDescription description = eduCourseDescriptionService.getById(id);
        courseInfoForm.setDescription(description.getDescription());
        return courseInfoForm;
    }

    @Override
    public void updateCourseInfo(CourseInfoForm courseInfoForm) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoForm,eduCourse);
        baseMapper.updateById(eduCourse);

        EduCourseDescription description = new EduCourseDescription();
        BeanUtils.copyProperties(courseInfoForm,description);
        eduCourseDescriptionService.updateById(description);
    }

    @Override
    public CoursePublishVo getCoursePublishVoById(String id) {
        return eduCourseMapper.selectCoursePublishVoById(id);
    }

    @Override
    public List<EduCourse> selectTest() {
        return eduCourseMapper.selectTest();
    }

    @Override
    public void deleteCourseById(String courseId) {

        //1 根据课程id删除小节
        eduVideoService.deleteVideoByCourseId(courseId);
        //2 根据课程id删除章节
        eduChapterService.removeChapterByCourseId(courseId);
        //3 根据课程id删除描述
        eduCourseDescriptionService.removeById(courseId);
        //4 根据课程id删除课程
        int result = baseMapper.deleteById(courseId);
        if (result==0){
            throw new AutoGuliException(20001,"删除失败");
        }
    }
}
