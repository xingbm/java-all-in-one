package org.share.java.jdk.concurrent.tools;

import java.util.concurrent.CountDownLatch;

/**
 * Created by DawnSailing on 2020/10/4 12:38
 */
public class CountDownLatchTest {

    /**
     * 设置计数器为 2
     */
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String [] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1");
                // 计数器减 1
                c.countDown();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2");
                // 计数器减 1
                c.countDown();
            }
        }).start();
        // 阻塞当前线程，直到 count 变为 0
        c.await();
        System.out.println("3");
    }

}
