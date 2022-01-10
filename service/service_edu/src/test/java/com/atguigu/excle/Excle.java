package com.atguigu.excle;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class Excle {
    public static void main(String[] args) {
        //excel写操作
        /*String fileName = "E:\\write.xlsx";

        EasyExcel.write(fileName,DemoData.class).sheet("学生表").doWrite(getList());*/

        //excel读操作
        String fileName = "E:\\write.xlsx";
        EasyExcel.read(fileName,DemoData.class,new ExcleLisenner()).sheet().doRead();
    }

    private static List<DemoData> getList(){
        List<DemoData> list = new ArrayList<>();
        for (int i=0; i<10;i++){
            DemoData demoData = new DemoData();
            demoData.setSno(i);
            demoData.setSname("学生"+i);
            list.add(demoData);
        }
        return list;
    }
}
