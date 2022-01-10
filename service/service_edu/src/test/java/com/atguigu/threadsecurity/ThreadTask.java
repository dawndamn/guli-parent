package com.atguigu.threadsecurity;

import java.util.Random;

public class ThreadTask implements Runnable {
    int x = new Random().nextInt(2);//0,1
    //指定线程要执行的任务代码
    @Override
    public void run() {
        while(true){
            if (x%2 ==0) {
                //情况一
                synchronized (MyLock.lockA) {
                    System.out.println("if-LockA");
                    synchronized (MyLock.lockB) {
                        System.out.println("if-LockB");
                        System.out.println("if大口吃肉");
                    }
                }
            } else {
                //情况二
                synchronized (MyLock.lockB) {
                    System.out.println("else-LockB");
                    synchronized (MyLock.lockA) {
                        System.out.println("else-LockA");
                        System.out.println("else大口吃肉");
                    }
                }
            }
            x++;
        }
    }

}
