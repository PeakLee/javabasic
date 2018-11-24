package com.kingpeak.java8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Stream 串行 & 并行.   conc:  并行 > 串行.
 * url:  https://blog.csdn.net/lengguoxing/article/details/78414960
 */
public class Stream01Test {

    public static void main(String[] args) {
        int size = 5000000;
        List<String> uuList = new ArrayList<String>();

        System.out.println("begin to fill: " + new Date());
        for (int i = 0; i < size; i++) {
            uuList.add(UUID.randomUUID().toString());
        }
        System.out.println("end to fill: " + new Date());

        // 串行.
        long startTime = System.nanoTime();
        uuList.stream().sorted().count();
        long endTime = System.nanoTime();
        long costTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("串行 cost: " + costTime);

        // 并行
        long startTime2 = System.nanoTime();
        uuList.parallelStream().sorted().count();
        long endTime2 = System.nanoTime();
        long costTime2 = TimeUnit.NANOSECONDS.toMillis(endTime2 - startTime2);
        System.out.println("并行 cost: " + costTime2);

        System.exit(0);
    }

}
