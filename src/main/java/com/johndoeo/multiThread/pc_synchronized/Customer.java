package com.johndoeo.multiThread.pc_synchronized;

import java.util.Queue;

public class Customer implements Runnable {
    private final Queue<Integer> queue;

    public Customer(Queue<Integer> queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == 0) {
                    queue.notify();
                    System.out.println("当前队列为空");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.poll();
                queue.notify();
                System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
