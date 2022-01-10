package com.atguigu.exception;

public class RuntimeExceptionDemo {
    public static void main(String[] args) {
        double d = getArea(0);
        System.out.println(d);
    }

    /*
     *  定义方法,计算圆形的面积
     *  传递参数0,或者负数,计算的时候没有问题
     *  但是,违反了真实情况
     *  参数小于=0, 停止程序,不要在计算了
     */
    public static double getArea(double r){
        if(r <= 0)
            throw new RuntimeException("圆形不存在");
        return r*r*Math.PI;
    }

}
