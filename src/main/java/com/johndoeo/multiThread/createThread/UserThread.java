package com.johndoeo.multiThread.createThread;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/4/24 21:49
 * @Description:
 */
public class UserThread {


    public static void main(String[] args){
        MyThread1 myThread = new MyThread1();
        myThread.start();
    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        System.err.println("新建的线程！！！");
    }
}
