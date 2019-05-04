package com.johndoeo.multiThread.createThread;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/4/24 21:51
 * @Description:
 */
public class UseRunnable {
    public static void main(String[] args){
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
    }
}

class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.err.println("新建线程2！！！");
    }
}