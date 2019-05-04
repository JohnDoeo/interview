package com.johndoeo.proxy.dynamicProxy;

/**
 *  目标对象实现了某一接口
 */
public class Singer implements ISinger{
    public void sing(String name){
        System.out.println("唱一首歌,歌名是："+name);
    }
}
