package com.johndoeo.multiThread.pc_synchronized;

import java.util.LinkedList;
import java.util.Queue;

public class TestPC {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Customer customer = new Customer(queue);
        Proverder proverder = new Proverder(queue);
        Thread t1 = new Thread(customer,"customer");
        Thread t2 = new Thread(proverder,"provider");
        t1.start();
        t2.start();
    }
}
