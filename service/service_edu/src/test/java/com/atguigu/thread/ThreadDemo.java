package com.atguigu.thread;

public class ThreadDemo {
    public static void main(String[] args) {

        //创建两个线程任务
        MyThread d = new MyThread();
        MyThread d2 = new MyThread();
        d.run();//没有开启新线程, 在主线程调用run方法
        d2.start();//开启一个新线程，新线程调用run方法



    }

    static int i=0;
}
