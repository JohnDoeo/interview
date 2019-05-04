package com.johndoeo.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 开启新线程的方法
 */
public class CreateThread {
    public static void main(String[] args){
//        Method1 method1 = new CreateThread().new Method1();
//        method1.start();


//        final Thread thread = new Thread(new CreateThread().new Method2());
//        thread.start();


//        Callable c = new CreateThread().new Method3();
//        FutureTask futureTask = new FutureTask<>(c);
//        Thread thread = new Thread(futureTask);
//        thread.run();


        //创建线程池
        final ExecutorService pool = Executors.newFixedThreadPool(2);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < 2; i++) {
            Callable c = new MyCallable(i + " ");
            // 执行任务并获取Future对象
            Future f = pool.submit(c);
            // System.out.println(">>>" + f.get().toString());
            list.add(f);
        }
        for(int i = 0;i < 100;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Method1 extends Thread{
        @Override
        public void run() {
            for(int i = 0;i < 100;i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }

    class Method2 implements Runnable{
        @Override
        public void run() {
            for(int i = 0;i < 100;i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }

    class Method3 implements Callable{
        @Override
        public Object call() {
            for(int i = 0;i < 100;i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            return null;
        }
    }

    class Method4{
//        Executor
    }
}

class MyCallable implements Callable<Object> {
    private String taskNum;

    MyCallable(String taskNum) {
        this.taskNum = taskNum;
    }
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName()+">>>" + taskNum + "任务启动");
        Date dateTmp1 = new Date();
        Thread.sleep(1000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(Thread.currentThread().getName()+">>>" + taskNum + "任务终止");
        return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
    }
}
