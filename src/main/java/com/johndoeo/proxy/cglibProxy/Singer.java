package com.johndoeo.proxy.cglibProxy;

/**
 *  目标对象实现了某一接口
 */
public class Singer {
    public String sing(){
        System.out.println("唱一首歌");
        return "代理方法的返回值";
    }
}
