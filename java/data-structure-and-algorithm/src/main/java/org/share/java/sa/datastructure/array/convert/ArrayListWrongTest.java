package org.share.java.sa.datastructure.array.convert;

import java.lang.reflect.Array;

/**
 * Created by DawnSailing on 2020/10/4 10:40
 */
public class ArrayListWrongTest {

    public static void main(String[] args) {
        //创建一个数组
        int[] array = new int[]{1,2,3};
        //获取数组中序列为0的元素
        Array.getInt(array, 0);
        //设置序列为0的元素值为1
        Array.set(array, 0, 1);
        // 此时list会被当成一个元素输出
        //List list = Arrays.asList(array);

    }

}
