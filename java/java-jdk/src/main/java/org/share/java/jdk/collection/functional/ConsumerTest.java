package org.share.java.jdk.collection.functional;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/**
 * Created by DawnSailing on 2020/10/8 9:30
 */
public class ConsumerTest {

    public static void main(String[] args) {
        // 消费方法举例
        method(200, money -> System.out.println("花了" + money));
        // DoubleConsumer example
        doubleMethod(200, money -> System.out.println("花了" + money));
    }

    public static void method(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    public static void doubleMethod(double money, DoubleConsumer doubleConsumer) {
        doubleConsumer.accept(money);
    }

}
