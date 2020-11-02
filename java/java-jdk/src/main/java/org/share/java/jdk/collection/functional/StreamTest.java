package org.share.java.jdk.collection.functional;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by DawnSailing on 2020/10/8 9:44
 */
public class StreamTest {

    public static void main(String[] args) {
        createStreamTest();
        map();
        reduce();
        collect();
        distinct();
        summaryStatistics();

    }

    private static void createStreamTest() {
        //方式一 通过集合创建Stream实例
        /*
         * 1.default Stream<E> stream():返回一个顺序流
         * 2.default Stream<E> parallelStream():返回一个并行流
         *
         */

        //方式二创建实例通过数组
        /*
         * 调用Arrays类的 static<T> Stream<T> stream(T[] array)：返回一个流
         *
         */
        int[] arr = new int[]{1,2,3,4,5};
        IntStream stream = Arrays.stream(arr);
        stream.forEach(value -> {System.out.print(value + " ");});
        System.out.println("------------");

        //方式三通过Stream的of()
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
        stream1.forEach(value -> {System.out.print(value + " ");});
        System.out.println("------------");

        //方式四创建无限流
        //1.迭代
        // public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        Stream.iterate(0,t -> t + 2).limit(5).forEach(System.out :: print);
        //2.生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }

    /**
     * 使用 Stream 对象的 map 方法将原来的列表经由 Lambda 表达式映射为另一个列表，并通过 collect 方法转换回 List 类型
     */
    private static void map() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> mapped = numbers.stream().map(x -> x * 2).collect(Collectors.toList());
        mapped.forEach(System.out::print);

        // map操作将原来的单词 转换成了每个单的长度，该方法返回类型为int
        Stream<String> stream = Stream.of("apple","banana","orange","waltermaleon","grape");
        stream.map(e->e.length()).forEach(e->System.out.println(e));
        stream.map(String::length).forEach(System.out::println);
        stream.mapToInt(e -> e.length()).forEach(e -> System.out.println(e));
        //转成long ,本质上是int 但是存在类型自动转换
        stream.mapToLong(e -> e.length()).forEach(e -> System.out.println(e));
        stream.mapToDouble(e -> e.length()).forEach(e -> System.out.println(e));

        // flatmap作用就是将元素拍平拍扁，将拍扁的元素重新组成Stream，并将这些Stream串行合并成一条Stream
        // flatmapToInt、flatmapToLong、flatmapToDouble 跟flatMap 都类似
        Stream<String> streamFlat = Stream.of("a-b-c-d", "e-f-i-g-h");
        streamFlat.flatMap(e->Stream.of(e.split("-"))).forEach(e->System.out.println(e));

    }

    /**
     * reduce 操作，就是通过二元运算对所有元素进行聚合，最终得到一个结果。
     * 例如使用加法对列表进行聚合，就是将列表中所有元素累加，得到总和。
     */
    private static void reduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce((x, y) -> x + y).get();
        System.out.println(sum);
    }

    private static void collect() {
        // 将操作之后的结果转换为集合
        List<Double> list = Arrays.asList(100.0, 200.0, 300.0, 500.0);
        List<Double> result = list.stream().filter(n -> n >= 200.0).collect(Collectors.toList());
        System.out.println(result);
        // 将操作之后的结果进行连接
        List<String> strList = Arrays.asList("java", "c", "c++", "python");
        String res = strList.stream().map(n -> n.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(res);
    }

    private static void distinct() {
        List<String> strList = Arrays.asList("java", "c", "c++", "python", "c++", "c", "java");
        List<String> result = strList.stream().filter(n -> n.startsWith("c")).distinct().collect(Collectors.toList());
        System.out.println(result);

        Stream.of(1,2,3,1,2,5,6,7,8,0,0,1,2,3,1)
                .distinct() //去重
                .forEach(e->System.out.println(e));

    }

    private static void summaryStatistics() {
        List<Double> list = Arrays.asList(100.0,200.0,300.0,400.0,500.0);
        DoubleSummaryStatistics dss = list.stream().mapToDouble(n -> n).summaryStatistics();
        System.out.println("sum:" + dss.getSum());
        System.out.println("average:" + dss.getAverage());
        System.out.println("count:" + dss.getCount());
        System.out.println("max:" + dss.getMax());
        System.out.println("min:" + dss.getMin());

    }

    private static void limit() {
        //将输出 前三个 1，2，3
        Stream.of(1,2,3,4,5,6).limit(3).forEach(e->System.out.println(e));
    }

    private static void filter() {
        //过滤小于5的
        Stream.of(1,2,3,1,2,5,6,7,8,0,0,1,2,3,1).filter(e->e>=5).forEach(e->System.out.println(e));
    }

}
