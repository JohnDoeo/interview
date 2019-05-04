package com.johndoeo.multiThread;

public class PrintOrder {
    public static void main(String[] args) {
//        final PrintOrder printOrder = new PrintOrder();
//        printOrder.run();

        System.out.println(10+20+"aa");
    }

    private Object obj = new Object();
    private int count = 0;

    private Thread t1 = new Thread(() -> {
        while (true) {
            synchronized (obj) {

                for (int i = 65; i <= 91; ) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (count % 2 == 0) {
                        System.out.println((char) i);
                        i++;
                        count++;
                        obj.notify();
                    } else {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    });

    private Thread t2 = new Thread(() -> {
        int i = 1;
        while (true) {
            synchronized (obj) {
                if (count % 2 == 1) {
                    System.out.println(i);
                    i++;
                    count++;
                    obj.notify();
                } else {
                    System.out.println("当前count的值是："+count);
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    });

    public void run() {
        t2.start();
        t1.start();
    }
}
