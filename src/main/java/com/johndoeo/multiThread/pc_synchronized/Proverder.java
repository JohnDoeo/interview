package com.johndoeo.multiThread.pc_synchronized;

import java.util.Queue;

public class Proverder implements Runnable{

    private static final int MAX_LEN = 10;
    private final Queue<Integer> queue;

    public Proverder(Queue<Integer> queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.size()== MAX_LEN){
                    queue.notify();
                    System.out.println(Thread.currentThread().getName()+":当前队列已满=>"+ queue.size());
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add(1);
                queue.notify();
                System.out.println("生产者生产一条任务，当前队列长度为" + queue.size());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
