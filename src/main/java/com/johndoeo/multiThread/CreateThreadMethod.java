package com.johndoeo.multiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的三种方法
 */
public class CreateThreadMethod {

    public static void main(String[] args) {
//        ConcurrentHashMap
//        new MyThread1().start();
//        new Thread(new MyThread2()).start();
        FutureTask<MyThread3> task = new FutureTask<MyThread3>(new MyThread3());
        new Thread(task).start();
        task.hashCode();
        task.equals(22);
        for(int i = 0;i < 100;i++){
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
            try{
                System.out.println(task.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        try{
            System.out.println(task.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static class MyThread1 extends Thread{
        @Override
        public void run() {
            for(int i = 0;i < 100;i++){
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }

    static class MyThread2 implements Runnable{
        @Override
        public void run() {
            for(int i = 0;i < 100;i++){
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }

    static class MyThread3 implements Callable {
        @Override
        public Object call() {
            for(int i = 0;i < 100;i++){
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            return "返回信息？？？";
        }
    }
}
