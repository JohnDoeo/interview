package com.johndoeo.multiThread.pc_blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestPC {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(10);
        final Thread t1 = new Thread(new Provider(queue));
        final Thread t2 = new Thread(new Customer(queue));
        t1.start();
        t2.start();
    }
}
