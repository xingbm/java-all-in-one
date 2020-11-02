package org.share.java.jdk.collection.functional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DawnSailing on 2020/10/8 10:15
 */
public class MethodReferenceTest {

    public static void main(String[] args) {
        // 如果只需要调用单个函数对列表元素进行处理，那么可以使用更加简洁的 方法引用 代替 Lambda 表达式：
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(System.out::println);

    }

}
