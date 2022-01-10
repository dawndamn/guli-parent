package com.atguigu.ioStream;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class fileTest {
    @Test
    public void test1() throws IOException {
        File file = new File("d:\\eclipse\\eclipse.exe");
        String name = file.getName();
        System.out.println(name);
        String path = file.getPath();
        System.out.println(path);

    }

    @Test
    public void function_2(){
        //获取系统中的所有根目录
        File[] fileArr = File.listRoots();
        for(File f : fileArr){
            System.out.println(f);
        }
    }

    @Test
    public void function_1(){
        File file = new File("d:\\eclipse");
        File[] fileArr = file.listFiles();
        for(File f : fileArr){
            System.out.println(f);
        }
    }

    @Test
    public void function(){
        File file = new File("c:");
        String[] strArr = file.list();
        System.out.println(strArr.length);
        for(String str : strArr){
            System.out.println(str);
        }
    }



    public static void main(String[] args) {
        File dir = new File("d:\\eclipse");
        getAllDir(dir);
    }
    /*
     *  定义方法,实现目录的全遍历
     */
    public static void getAllDir(File dir){
        System.out.println(dir);

        //调用方法listFiles()对目录,dir进行遍历
        File[] fileArr = dir.listFiles();
        for(File f : fileArr){
            //判断变量f表示的路径是不是文件夹
            if(f.isDirectory()){
                //是一个目录,就要去遍历这个目录
                //本方法,getAllDir,就是给个目录去遍历
                //继续调用getAllDir,传递他目录
                getAllDir(f);
            }else{
                System.out.println(f);
            }
        }

    }





}
