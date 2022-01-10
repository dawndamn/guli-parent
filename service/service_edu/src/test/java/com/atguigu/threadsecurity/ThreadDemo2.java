package com.atguigu.threadsecurity;

public class ThreadDemo2 {
    public static void main(String[] args) {
        //创建线程任务类对象
        ThreadTask task = new ThreadTask();
        //创建两个线程
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        //启动线程
        t1.start();
        t2.start();
    }

}
