package org.share.java.jdk.collection.traversal;

import java.util.ArrayDeque;

/**
 * Created by DawnSailing on 2020/10/4 9:29
 */
public class Queue {

    public static void main(String[] args) {
        java.util.Queue<String> items = new ArrayDeque<>();
        items.add("a");
        items.add("b");
        items.add("c");

        while(!items.isEmpty()){
            /*一顿操作*/
            System.out.println(items.poll());
        }

    }

}
