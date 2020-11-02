package org.share.java.jdk.collection.functional;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Created by DawnSailing on 2020/10/8 9:17
 */
public class LambdaTest {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("实现runnable接口");
            }
        };
        runnable.run();
        Thread t = new Thread(runnable);
        t.start();
        System.out.println("-----------------------------------------------");

        //使用lambda表达式
        Runnable runnable1 = () -> System.out.println("runnable实现匿名接口");
        runnable1.run();


        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(comparator.compare(11,22));

        //使用lambda表达式
        Comparator<Integer> comparator1 = (o1,o2) -> Integer.compare(o1,o2);
        //方法引用写法
        Comparator<Integer> comparator2 = Integer :: compare;
        System.out.println(comparator1.compare(22,33));
        System.out.println(comparator2.compare(22,23));


        /*
         * Lambda表达式的使用举例
         *
         */
        //方式一：无参无返回值
        Runnable run = () -> System.out.println("方式一");

        //方式二：需要一个参数，但是没有返回值
        Consumer<String > consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("方式二");
        Consumer<String > consumer1 = (String s)->{System.out.println(s);};
        consumer1.accept("lambda方式二");

        //方式三数据类型可以省略类型推断
        Consumer<String > consumer2 = (s)->{System.out.println(s);};
        consumer2.accept("方式三");
        //方式四：lambda若只需要一个参数参数小括号可以省略
        Consumer<String > consumer3 = s ->{System.out.println(s);};
        consumer2.accept("方式四");

        //方式五：需要两个以上参数并可能有返回值
        Comparator<Integer> comparator3 = (o1,o2) -> {return o1.compareTo(o2);};
        System.out.println(comparator3.compare(1,2));
        //方式六：当lambda只有一条语句时return与大括号若有都可省略
        Comparator<Integer> comparator4 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(comparator4.compare(1,2));

    }

}
