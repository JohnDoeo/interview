package com.johndoeo.multiThread.t1;

import java.util.Queue;
import java.util.Random;

public class Producer  implements Runnable{
    private Queue<Integer> queue;
    private int maxSize;
    private volatile int count = 0;
    private int allSize;
    public Producer(Queue<Integer> queue, int maxSize,int allSize){
        this.queue = queue;
        this.maxSize = maxSize;
        this.allSize=allSize;
    }
    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.size() == maxSize){
                    try{
                        System.out.println("Queue is Full");
                        queue.wait();
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("Produce " + i);
                queue.add(i);
                count++;
                queue.notifyAll();
                if(count==allSize){
                    break;
                }
            }
        }
    }
}
