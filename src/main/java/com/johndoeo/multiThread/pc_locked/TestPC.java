package com.johndoeo.multiThread.pc_locked;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestPC {
    public static void main(String[] args) {
        final Queue<Integer> queue = new LinkedList<>();
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        Thread t1 = new Thread(new Customer(queue, lock, condition));
        Thread t2 = new Thread(new Provider(queue, lock, condition));
        t1.start();
        t2.start();
    }
}
