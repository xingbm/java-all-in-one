package org.share.java.jdk.collection.convert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DawnSailing on 2020/10/4 11:54
 */
public class ListToArrayTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(3);
        list.add("a");
        list.add("b");
        list.add("c");

        String[] strArray = list.toArray(new String[list.size()]);
        for (String str: strArray) {
            System.out.println(str);
        }

        // java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
        String[] array = (String[])list.toArray();
        for (String str: array) {
            System.out.println(str);
        }

    }

}
