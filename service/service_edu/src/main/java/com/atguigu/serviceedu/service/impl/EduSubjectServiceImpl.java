package com.atguigu.serviceedu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.serviceedu.entity.EduSubject;
import com.atguigu.serviceedu.entity.excle.ExcleSubjectData;
import com.atguigu.serviceedu.entity.subject.OneSubject;
import com.atguigu.serviceedu.entity.subject.TowSubject;
import com.atguigu.serviceedu.lisener.SubjectExcelListener;
import com.atguigu.serviceedu.mapper.EduSubjectMapper;
import com.atguigu.serviceedu.service.EduSubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-02-23
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile multipartFile, EduSubjectService eduSubjectService) {

        try {
            InputStream in = multipartFile.getInputStream();
            EasyExcel.read(in, ExcleSubjectData.class,new SubjectExcelListener(eduSubjectService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<OneSubject> findOneAndTowSubject() {

        //查询所有一级分类
        QueryWrapper<EduSubject> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("parent_id", "0");
        List<EduSubject> eduSubjects1 = baseMapper.selectList(queryWrapper1);

        //查询所有二级分类
        QueryWrapper<EduSubject> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.ne("parent_id", "0");
        List<EduSubject> eduSubjects2 = baseMapper.selectList(queryWrapper2);

        //创建最终集合
        List<OneSubject> finalSubjectList = new ArrayList<>();

        //封装一级分类
        for (int i = 0; i < eduSubjects1.size(); i++) {
            OneSubject oneSubject = new OneSubject();
            EduSubject eduSubject = eduSubjects1.get(i);
            BeanUtils.copyProperties(eduSubject,oneSubject);
            finalSubjectList.add(oneSubject);

            //封装二级分类
            List<TowSubject> towSubjectList = new ArrayList<>();

            for (int m = 0; m < eduSubjects2.size(); m++) {
                EduSubject eduSubject2 = eduSubjects2.get(m);
                if (eduSubject2.getParentId().equals(eduSubject.getId())){
                    TowSubject towSubject = new TowSubject();
                    BeanUtils.copyProperties(eduSubject2,towSubject);
                    towSubjectList.add(towSubject);
                }

            }

            oneSubject.setChildrens(towSubjectList);
        }

        return finalSubjectList;
    }
}
