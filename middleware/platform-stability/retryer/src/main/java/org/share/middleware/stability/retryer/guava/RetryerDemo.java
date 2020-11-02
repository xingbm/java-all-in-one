package org.share.middleware.stability.retryer.guava;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by xingbm on 2020/10/30 7:40
 */
public class RetryerDemo {

    public static void main(String[] args) {
        retryer();
    }

    private static void retryer() {
        Retryer retryer = RetryerBuilder.newBuilder()
                // 抛出异常会进行重试
                .retryIfException()
                // 如果接口返回的结果不符合预期，也需要重试
                .retryIfResult(Predicates.equalTo(Boolean.FALSE))
                // 重试策略，此处设置的重试间隔时间
                .withWaitStrategy(WaitStrategies.fixedWait(10, TimeUnit.SECONDS))
                // 重试次数
                .withStopStrategy(StopStrategies.stopAfterAttempt(5))
                .build();
        try {
            retryer.call(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    System.out.println("第n次执行业务逻辑");
                    Boolean result = demo();
                    return result;
                }
            });
        } catch (RetryException| ExecutionException e) {

        }
    }

    private static boolean demo() {
        try {
            throw new RuntimeException("异常了");
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

}
