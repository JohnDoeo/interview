package com.johndoeo.day214;

/**
 * 饿汉式
 */
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1(){}
    public static Singleton1 getInstance(){
        return instance;
    }
}
