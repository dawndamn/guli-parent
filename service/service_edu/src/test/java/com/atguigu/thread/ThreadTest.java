package com.atguigu.thread;

import org.junit.Test;

public class ThreadTest {
    @Test
    public void test1(){

        MyThread mt = new MyThread("新的线程！");
        //开启新线程
        mt.start();
        //在主方法中执行for循环
        /*for (int i = 0; i < 10; i++) {
            System.out.println("main线程！"+i);
        }*/

    }
}
