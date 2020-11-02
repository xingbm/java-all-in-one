package org.share.java.jdk.concurrent.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by DawnSailing on 2020/10/4 12:51
 */
public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    /**
     * 最大并发数是 10
     */
    private static Semaphore s = new Semaphore(10);

    public static void main(String [] args) {
        // 虽然有30个线程，但最多只有10个并发执行
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获取一个许可
                        s.acquire();
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                        // 释放一个许可
                        s.release();
                    } catch (InterruptedException e) {
                    }
                }
            });
        }
        threadPool.shutdown();
    }

}
