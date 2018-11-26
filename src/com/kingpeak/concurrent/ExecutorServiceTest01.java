package com.kingpeak.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newFixedThreadPool;


/**
 * 线程池： ExecutorService  + Runnable/Thread + Callable
 * url: http://www.runoob.com/java/java-multithreading.html
 * @date 20181126
 */
public class ExecutorServiceTest01 {

    public static void main(String[] args) {
        // 线程池对象， 5个线程
        ExecutorService service = newFixedThreadPool(5);

        //##1 创建线程
        TaskRunnale task = new TaskRunnale();
        // 从线程池中获取线程对象
        service.submit(task);
        System.out.println("-------------------");
        // 再获取一个线程对象
        service.submit(task);


        //##2 获取线程执行结果
        MyCallable c = new MyCallable(10, 300);
        MyCallable c2 = new MyCallable(20, 40);

        try {
            Future<Integer> result = service.submit(c);
            Integer sum = result.get();
            System.out.println("sum1 = " + sum);

            result = service.submit(c2);
            sum = result.get();
            System.out.println("sum2 = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        // shutdown service.
        service.shutdown();
        System.exit(0);
    }
}

// demo1:
class TaskRunnale implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("customized thread is running " + i);
        }
    }
}

// demo2:
class MyCallable implements Callable<Integer> {
    //
    int x = 5;
    int y = 3;

    public MyCallable() {}

    public MyCallable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {

        return x + y;
    }
}