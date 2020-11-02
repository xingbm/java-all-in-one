package org.share.java.jdk.concurrent.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by DawnSailing on 2020/10/4 12:43
 */
public class CyclicBarrierTest {

    /**
     * 屏障打开后，优先执行 new A()
     */
    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    // 到达屏障 阻塞当前线程
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("1");
            }

        }).start();
        try {
            Thread.sleep(1000);
            // 到达屏障 阻塞当前线程
            c.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("2");
    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println("3");
        }
    }

}
