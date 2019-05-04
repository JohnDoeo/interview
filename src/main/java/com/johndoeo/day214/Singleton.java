package com.johndoeo.day214;

/**
 * 懒汉式（线程不安全的）
 */
//public class Singleton{
//    private static Singleton instance;
//    private Singleton(){}
//    public static Singleton getInstance(){
//        if(instance == null){
//            return new Singleton();
//        }else{
//            return instance;
//        }
//    }
//}

/**
 * 懒汉式（线程安全的）
 */
public class Singleton{
    private static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                return new Singleton();
            }
        }else{
            return instance;
        }
    }
}
