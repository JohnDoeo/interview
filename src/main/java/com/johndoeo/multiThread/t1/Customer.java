package com.johndoeo.multiThread.t1;

import java.util.Queue;

public class Customer implements Runnable{
    private Queue<Integer> queue;
    private int maxSize;
    private volatile int count = 0;
    private int allSize;
    public Customer(Queue<Integer> queue, int maxSize,int allSize){
        this.queue = queue;
        this.maxSize = maxSize;
        this.allSize=allSize;
    }
    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.isEmpty()){
                    System.out.println("Queue is Empty");
                    try{
                        queue.wait();
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
                int v = queue.remove();
                count++;
                queue.notifyAll();
                System.out.println("Consume " + v);
                if(count==allSize){
                    break;
                }
            }
        }
    }
}
