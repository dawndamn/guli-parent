package com.atguigu.recursive;

public class DiGuiDemo {
    public static void main(String[] args) {
        int sum = getSum(10);
        System.out.println(sum);
    }



    public static int getSum(int n){
        if( n == 1)
            return 1;
        return n + getSum(n-1);
    }

}
