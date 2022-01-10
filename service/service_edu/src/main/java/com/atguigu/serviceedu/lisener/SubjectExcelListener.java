package com.atguigu.serviceedu.lisener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.servicebase.config.exceptionHandler.AutoGuliException;
import com.atguigu.serviceedu.entity.EduSubject;
import com.atguigu.serviceedu.entity.excle.ExcleSubjectData;
import com.atguigu.serviceedu.service.EduSubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

public class SubjectExcelListener extends AnalysisEventListener<ExcleSubjectData> {

    private EduSubjectService eduSubjectService;

    public SubjectExcelListener() {
    }

    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }



    @Override
    public void invoke(ExcleSubjectData subjectData, AnalysisContext analysisContext) {
        if (subjectData ==null){
            throw new AutoGuliException(20001,"文件为空");
        }

        //添加一级分类
        EduSubject eduSubject = existOneSubject(eduSubjectService, subjectData.getOneSubjectName());
        if (eduSubject==null){
            eduSubject = new EduSubject();
            eduSubject.setParentId("0");
            eduSubject.setTitle(subjectData.getOneSubjectName());
            eduSubjectService.save(eduSubject);
        }

        String pid = eduSubject.getId();
        //添加二级分类
        EduSubject eduSubject1 = existTwoSubject(eduSubjectService, subjectData.getTwoSubjectName(),pid);
        if (eduSubject1==null){
            eduSubject1 = new EduSubject();
            eduSubject1.setParentId(pid);
            eduSubject1.setTitle(subjectData.getTwoSubjectName());
            eduSubjectService.save(eduSubject1);
        }
    }

    //判断一级分类不能重复添加
    private EduSubject existOneSubject(EduSubjectService eduSubjectService,String name){
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id","0");
        EduSubject eduSubject = eduSubjectService.getOne(queryWrapper);
        return eduSubject;
    }

    //判断一级分类不能重复添加
    private EduSubject existTwoSubject(EduSubjectService eduSubjectService,String name,String pid){
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id",pid);
        EduSubject eduSubject = eduSubjectService.getOne(queryWrapper);
        return eduSubject;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
