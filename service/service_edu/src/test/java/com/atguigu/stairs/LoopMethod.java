package com.atguigu.stairs;

public class LoopMethod {
    public int loop(int n){
        if (n==1 || n==2){
            return n;
        }
        int one = 2; //最后跨两步走法
        int tow = 1; //最后跨一步走法
        int sum = 0; //总走法

        // f(n)=f(n-2)+f(n-1)
        for (int i=3;i<=n;i++){
            sum = one +tow;
            tow = one;
            one = sum;

        }
        return sum;
    }
}
