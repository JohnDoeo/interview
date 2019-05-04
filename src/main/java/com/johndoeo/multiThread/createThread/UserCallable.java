package com.johndoeo.multiThread.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/4/24 21:54
 * @Description:
 */
public class UserCallable {
    public static void main(String[] args){
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>) () -> {
            return 5;
        });
        try {
            new Thread(task).start();
            Integer integer = task.get();
            System.err.println(integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
