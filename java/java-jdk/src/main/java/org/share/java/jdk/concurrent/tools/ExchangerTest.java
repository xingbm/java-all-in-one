package org.share.java.jdk.concurrent.tools;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by DawnSailing on 2020/10/4 12:54
 */
public class ExchangerTest {

    private static final Exchanger<String> EXCHANGER = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String [] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";
                    System.out.println("A录入的是： " + A);
                    // 将对象 A 传递到另一个线程，并接受的另一个线程传递过来的值。
                    A = EXCHANGER.exchange(A);
                    System.out.println("A录入的是： " + A);
                } catch (InterruptedException e) {
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    String B = "银行流水B";
                    System.out.println("B录入的是： " + B);
                    B = EXCHANGER.exchange(B);
                    System.out.println("B录入的是： " + B);
                } catch (InterruptedException e) {
                }
            }
        });
        threadPool.shutdown();
    }

}
