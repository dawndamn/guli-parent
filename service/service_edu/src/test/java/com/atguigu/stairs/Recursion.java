package com.atguigu.stairs;

public class Recursion {
    public int recursion(int n){
        if (n==1 || n==2){
            return n;
        }
        return recursion(n-2)+recursion(n-1);
    }
}
