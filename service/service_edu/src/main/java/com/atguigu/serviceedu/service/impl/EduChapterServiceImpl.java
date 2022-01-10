package com.atguigu.serviceedu.service.impl;

import com.atguigu.servicebase.config.exceptionHandler.AutoGuliException;
import com.atguigu.serviceedu.entity.EduChapter;
import com.atguigu.serviceedu.entity.EduVideo;
import com.atguigu.serviceedu.entity.chapter.ChapterVo;
import com.atguigu.serviceedu.entity.chapter.VideoVo;
import com.atguigu.serviceedu.mapper.EduChapterMapper;
import com.atguigu.serviceedu.service.EduChapterService;
import com.atguigu.serviceedu.service.EduVideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService eduVideoService;

    @Override
    public List<ChapterVo> getChapterVideo(String courseId) {

        //查找所有章节数据
        QueryWrapper<EduChapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        List<EduChapter> eduChapterList = baseMapper.selectList(queryWrapper);

        //查找所有小节数据
        QueryWrapper<EduVideo> videoWrapper = new QueryWrapper<>();
        videoWrapper.eq("course_id",courseId);
        List<EduVideo> eduVideoList = eduVideoService.list(videoWrapper);

        List<ChapterVo> chapterVoList = new ArrayList<>();

        for (int i = 0; i < eduChapterList.size(); i++) {
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(eduChapterList.get(i),chapterVo);

            chapterVoList.add(chapterVo);

            List<VideoVo> videoVoList = new ArrayList<>();
            for (int j = 0; j <eduVideoList.size() ; j++) {
                VideoVo videoVo = new VideoVo();
                BeanUtils.copyProperties(eduVideoList.get(i),videoVo);
                videoVoList.add(videoVo);
            }
            chapterVoList.get(i).setChildren(videoVoList);

        }
        return chapterVoList;
    }

    @Override
    public void addChapter(EduChapter eduChapter) {
        baseMapper.insert(eduChapter);
    }

    @Override
    public boolean deleteChapter(String chapterId) {
        QueryWrapper<EduVideo> queryWrapper = new QueryWrapper();
        queryWrapper.eq("chapter_id",chapterId);
        int count = eduVideoService.count(queryWrapper);
        if (count>0){
            throw new AutoGuliException(20001,"章节下有小节");
        }else {
            int i = baseMapper.deleteById(chapterId);
            return i>0;
        }

    }

    @Override
    public void updateChapter(EduChapter eduChapter) {
        baseMapper.updateById(eduChapter);
    }

    @Override
    public EduChapter selectChapter(String chapterId) {
        EduChapter eduChapter = baseMapper.selectById(chapterId);
        return eduChapter;
    }

    @Override
    public void removeChapterByCourseId(String courseId) {
        QueryWrapper queryWrapper = new QueryWrapper<EduChapter>();
        queryWrapper.eq("course_id",courseId);
        baseMapper.delete(queryWrapper);
    }
}
