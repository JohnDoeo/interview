package com.johndoeo.multiThread.pc_locked;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Customer implements Runnable {
    private final int MAX_LEN = 10;
    private final Queue<Integer> queue;
    private final Lock lock;
    private final Condition condition;
    public Customer(Queue<Integer> queue,Lock lock,Condition condition){
        this.queue=queue;
        this.lock=lock;
        this.condition=condition;
    }
    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                while (queue.size() == 0) {
                    System.out.println("当前队列为空");
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.poll();
                condition.signal();
                System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
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
