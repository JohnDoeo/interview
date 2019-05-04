package com.johndoeo.multiThread.pc_blockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Provider implements Runnable{
    private BlockingQueue<Integer> queue;
    public Provider(BlockingQueue<Integer> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        while(true) {
            try {
                queue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产者生产一条任务，当前队列长度为" + queue.size());
            try {
                Thread.sleep(new Random().nextInt(1000)+500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
