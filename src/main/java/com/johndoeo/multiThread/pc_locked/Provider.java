package com.johndoeo.multiThread.pc_locked;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Provider implements Runnable{
    private final int MAX_LEN = 10;
    private final Queue<Integer> queue;
    private final Lock lock;
    private final Condition condition;
    public Provider(Queue<Integer> queue,Lock lock,Condition condition){
        this.queue=queue;
        this.lock=lock;
        this.condition=condition;
    }
    @Override
    public void run() {
        while(true) {
            lock.lock();
            try {
                while (queue.size() == MAX_LEN) {
                    System.out.println("当前队列满");
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add(1);
                condition.signal();
                System.out.println("生产者生产一条任务，当前队列长度为" + queue.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
