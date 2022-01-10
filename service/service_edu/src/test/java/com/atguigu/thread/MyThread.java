package com.atguigu.thread;

public class MyThread extends Thread implements Runnable{
    MyThread(){
        super();
    }
    MyThread(String name){
        super(name);
    }
    //复写其中的run方法
    public void run(){
        for (int i=1;i<=20 ;i++ ){
            System.out.println(Thread.currentThread().getName()+",i="+i);
        }
    }


}
