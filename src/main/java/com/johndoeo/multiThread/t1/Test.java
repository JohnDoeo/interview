package com.johndoeo.multiThread.t1;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    @org.junit.Test
    public void test1(){
        Queue<Integer> queue = new LinkedList<>();
        int maxInt = 2;
        int allSize = 10;
        Thread t1 = new Thread(new Producer(queue, maxInt,allSize));
        Thread t2 = new Thread(new Customer(queue, maxInt,allSize));
        t1.start();
        t2.start();
    }
}
