package com.atguigu.exception;

import org.junit.Test;

import java.security.cert.Extension;

public class ExTest {

    @Test
    public void test1(){
        int[] arr = new int[3];
        System.out.println(arr[0]);
        System.out.println(arr[3]);
        // 该句运行时发生了数组索引越界异常ArrayIndexOutOfBoundsException，
        // 由于没有处理异常，导致程序无法继续执行，程序结束。
        System.out.println("over"); // 由于上面代码发生了异常，此句代码不会执行

    }

    @Test
    public void test2(){
        int[] arr = new int[1024*1024*10];
        Zi z = new Zi();
        float f = 5+3.5f;
        System.out.println(z instanceof Fu);

    }
}
