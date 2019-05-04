package com.johndoeo.multiThread.pc_blockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable {
    private BlockingQueue<Integer> queue;
    public Customer(BlockingQueue<Integer> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        while (true) {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
            try {
                Thread.sleep(new Random().nextInt(1000)+500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
