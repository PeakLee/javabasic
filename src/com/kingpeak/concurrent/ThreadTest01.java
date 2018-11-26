package com.kingpeak.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 多线程编程基础:
 * url: http://www.runoob.com/java/java-multithreading.html
 * 3 ways to create thread: runnable + Thread + Callable&Future
 * @date 20181126
 */

public class ThreadTest01 {
    public static void main(String[] args) {
        // way #1:  Runnable interface.
        RunnableDemo r1 = new RunnableDemo("thread1");
        r1.start();
        RunnableDemo r2 = new RunnableDemo("thread2");
        r2.start();

        // way #2: Thread class.
        ThreadDemo t1 = new ThreadDemo("thread3");
        t1.start();
        ThreadDemo t2 = new ThreadDemo("thread4");
        t2.start();

        // way #3: Callable interfaces.
        CallableThreadDemo ctd = new CallableThreadDemo();
        FutureTask<Integer> ft = new FutureTask<Integer>(ctd);

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " 's variable is :" + i);
            if (i == 20) {
                new Thread(ft, "returned thread").start();
            }
        }
        try {
            System.out.println("the returned value is: " + ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

// via Runnable.
class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("create thread: " + threadName);
    }

    @Override
    public void run() {
        System.out.println("running " + threadName);
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            // e.printStackTrace();
            System.out.println("Thread " + threadName + " interrupted.");
        }

        System.out.println(this.threadName + " exiting..");
    }

    public void start() {
        System.out.println("starting  " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

// via Thread.
class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    public ThreadDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("create thread: " + threadName);
    }

    @Override
    public void run() {
        System.out.println("running " + threadName);
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            // e.printStackTrace();
            System.out.println("Thread " + threadName + " interrupted.");
        }

        System.out.println(this.threadName + " exiting..");
    }

    @Override
    public void start() {
        System.out.println("starting  " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

// via Callable.
class CallableThreadDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        //return null;
        int i = 0;
        for (; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}

