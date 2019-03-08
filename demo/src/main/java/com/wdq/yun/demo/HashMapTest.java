package com.wdq.yun.demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wudq
 * @date 2019/2/28 002811
 * @Description: TODO
 */
public class HashMapTest {
    public static void main(String[] args) throws Exception{

        ConcurrentHashMap<String ,Integer> concurrentHashMap = new ConcurrentHashMap<>();
        crunchifyPerformTest(concurrentHashMap);

        Map<String, Integer> strMap = new Hashtable<>();
        crunchifyPerformTest(strMap);

        Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
        crunchifyPerformTest(syncMap);


    }

    public static void crunchifyPerformTest(final Map<String, Integer> crunchifyThreads) throws InterruptedException {

        System.out.println("Test started for: " + crunchifyThreads.getClass());
        long averageTime = 0;
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            ExecutorService crunchifyExServer = new ThreadPoolExecutor(
                5,
                5,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
            for (int j = 0; j < 5; j++) {
                crunchifyExServer.execute(new Runnable() {
                    @SuppressWarnings("unused")
                    @Override
                    public void run() {

                        for (int i = 0; i < 500000; i++) {
                            Integer crunchifyRandomNumber = (int) Math.ceil(Math.random() * 550000);

                            // Retrieve value. We are not using it anywhere
                            Integer crunchifyValue = crunchifyThreads.get(String.valueOf(crunchifyRandomNumber));

                            // Put value
                            crunchifyThreads.put(String.valueOf(crunchifyRandomNumber), crunchifyRandomNumber);
                        }
                    }
                });
            }

            // Make sure executor stops
            crunchifyExServer.shutdown();

            // Blocks until all tasks have completed execution after a shutdown request
            crunchifyExServer.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

            long entTime = System.nanoTime();
            long totalTime = (entTime - startTime) / 1000000L;
            averageTime += totalTime;
            System.out.println("2500K entried added/retrieved in " + totalTime + " ms");
        }
        System.out.println("For " + crunchifyThreads.getClass() + " the average time is " + averageTime / 5 + " ms\n");
    }
}
