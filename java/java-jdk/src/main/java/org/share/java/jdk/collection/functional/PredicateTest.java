package org.share.java.jdk.collection.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by DawnSailing on 2020/10/8 10:18
 */
public class PredicateTest {

    public static void main(String[] args) {

        withoutUsingPredicate();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> words = Arrays.asList("a", "ab", "abc");
        filter(numbers, x -> (int)x % 2 == 0);
        filter(words, x -> ((String)x).length() > 1);

        collection();

    }

    private static void withoutUsingPredicate() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> words = Arrays.asList("a", "ab", "abc");
        numbers.forEach(x -> {
            if (x % 2 == 0) {
                //process logic
            }
        });
        words.forEach(x -> {
            if (x.length() > 1) {
                //process logic
            }
        });
    }

    /**
     * 使用 Predicate 接口，将相同的处理逻辑封装到 filter 方法中，重复调用
     * @param list
     * @param condition
     */
    private static void filter(List list, Predicate condition) {
        // 方法一
        list.forEach(x -> {
            if (condition.test(x)) {
                //process logic
            }
        });

        // 方法二
        list.stream().filter(x -> condition.test(x)).forEach(x -> {
            //process logic
        });

    }

    private static void collection() {
        // 集合相关操作
        List<String> list = Arrays.asList("java", "c", "python", "php", "c++", "c++");
        // Predicate之单个过滤条件
        Predicate<String> p1 = (n) -> n.startsWith("c");
        Predicate<String> p2 = (n) -> n.length() == 3;
        // 直接在filter中写过滤条件或者传入一个Predicate都行
        list.stream().filter(p1).forEach(System.out::println);
        list.stream().filter(n -> n.startsWith("c")).forEach(System.out::println);
        // Predicate之多个过滤条件
        // 若需要多个过滤条件，而不是单单的一个过滤条件，那么怎么实现呢？
        // Predicate提供类似于逻辑操作符AND和OR的方法，名字叫做and()和or()，用于将传入 filter() 方法的条件合并起来。
        // and()将满足条件的结果查询出来，or()将满足其中任意一个条件的结果查询出来
        list.stream().filter(p1.and(p2)).forEach(System.out::println);
        list.stream().filter(p1.or(p2)).forEach(System.out::println);
    }


}
