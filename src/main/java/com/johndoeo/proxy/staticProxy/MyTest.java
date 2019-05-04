package com.johndoeo.proxy.staticProxy;

public class MyTest {
    public static void main(String[] args){
        //目标对象
        ISinger target = new Singer();
        //代理对象
        ISinger proxy = new SingerProxy(target);
        //执行的是代理的方法
        proxy.sing();
    }
}
