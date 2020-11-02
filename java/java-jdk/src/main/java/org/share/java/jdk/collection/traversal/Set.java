package org.share.java.jdk.collection.traversal;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by DawnSailing on 2020/10/4 8:34
 */
public class Set {

    public static void main(String[] args) {
        java.util.Set<String> set = new HashSet<>(3);
        set.add("java");
        set.add("hello");
        set.add("world");

        //转数组
        System.out.println("第一种遍历方式：转数组");
		Object[] obj = set.toArray();
		for(int i = 0; i<obj.length; i++){
			System.out.println(obj[i]);
		}

        //迭代器
        System.out.println("第一种遍历方式：迭代器");
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}

        //增强for
        System.out.println("第一种遍历方式：增强for");
        for (String string : set) {
            System.out.println(string);
        }

    }

}
