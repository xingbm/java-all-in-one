package org.share.java.jdk.concurrent.tools;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by DawnSailing on 2020/10/4 12:48
 */
public class BankWaterService implements Runnable {

    /**
     * 创建  4 个屏障，处理完之后运行当前类的 run 方法
     */
    private CyclicBarrier c = new CyclicBarrier(4, this);
    /**
     * 创建一个包含 4 个线程的线程池
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    try {
                        Thread.sleep(1000);
                        // 插入屏障
                        c.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String [] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }

}
