package org.share.java.sa.datastructure.array.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by DawnSailing on 2020/10/4 10:49
 */
public class ArrayToList {

    public static void main(String[] args) {
        //
        //item1();
        //
        //item2();
        //
        item3();
    }

    private static void item1() {
        String[] strArray = new String[2];
        List<String> list = Arrays.asList(strArray);
        //对转换后的list插入一条数据
        list.add("1");
        System.out.println(list);
    }


    private static void item2() {
        String[] strArray = new String[2];
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strArray)) ;
        list.add("1");
        System.out.println(list);
    }

    private static void item3() {
        String[] strArray = new String[2];
        ArrayList<String> arrayList = new ArrayList<>(strArray.length);
        Collections.addAll(arrayList, strArray);
        arrayList.add("1");
        System.out.println(arrayList);
    }

}
