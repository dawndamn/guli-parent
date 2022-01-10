package com.atguigu.stairs;

public class Test {

    @org.junit.Test
    public void testLoopMethod(){
        LoopMethod loopMethod = new LoopMethod();
        long start = System.currentTimeMillis();
        System.out.println(loopMethod.loop(40));
        long end = System.currentTimeMillis();
        System.out.println("用时："+(end-start));
    }

    @org.junit.Test
    public void testRecursion(){
        Recursion recursion = new Recursion();
        long start = System.currentTimeMillis();
        System.out.println(recursion.recursion(40));
        long end = System.currentTimeMillis();
        System.out.println("用时："+(end-start));
    }
}
