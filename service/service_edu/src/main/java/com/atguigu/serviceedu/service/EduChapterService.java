package com.atguigu.serviceedu.service;

import com.atguigu.serviceedu.entity.EduChapter;
import com.atguigu.serviceedu.entity.chapter.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-03-23
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideo(String courseId);

    void addChapter(EduChapter eduChapter);

    boolean deleteChapter(String chapterId);

    void updateChapter(EduChapter eduChapter);

    EduChapter selectChapter(String chapterId);

    void removeChapterByCourseId(String courseId);
}
