package com.atguigu.recursive;

public class Demo2 {
    public static void main(String[] args) {
        System.out.println(getJieCheng(10));

    }

    /*
     *  计算阶乘 5!
     *   5*4*3*2*1
     */
    public static int getJieCheng(int n){
        if ( n == 1)
            return 1;
        return n * getJieCheng(n-1);
    }

}
