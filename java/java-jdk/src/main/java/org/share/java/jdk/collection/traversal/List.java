package org.share.java.jdk.collection.traversal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by DawnSailing on 2020/10/4 8:34
 */
public class List {

    public static void main(String[] args) {
        // item1();
        item2();
    }

    private static void item1() {
        ArrayList list = new ArrayList(6);
        list.add(123);
        list.add("AAAA");
        list.add("bb");
        list.add(new String("JavaEE"));
        list.add(new Date());
        list.add(false);

        // 遍历
        //1.Iterator迭代器方式
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //2.增强for循环
        for(Object obj:list){
            System.out.println(obj);
        }

        //3.普通for循环
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    private static void item2() {
        java.util.List<String> items = new ArrayList<>(3);
        items.add("A");
        items.add("B");
        items.add("C");

        // 普通for循环遍历
        System.out.println("第一种遍历方式：普通for循环遍历 List 集合");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }

        // 增强for循环遍历
        System.out.println("\n第二种遍历方式：增强for循环遍历 List 集合");
        for (String item : items) {
            System.out.println(item);
        }

        // Lambda 表达式遍历（JDK 1.8）
        System.out.println("\n第三种遍历方式：Lambda 表达式遍历 List 集合");
        items.forEach(item->{ System.out.println(item);});

        // Lambda 表达式遍历（JDK 1.8）
        System.out.println("\n第四种遍历方式：Lambda 表达式遍历 List 集合");
        items.forEach(System.out::println);

    }

}
