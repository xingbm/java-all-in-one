package org.share.java.jdk.reflect.base;

/**
 * Created by xingbm on 2020/10/30 8:05
 */
public class ClassDemo {

    public static void main(String[] args) {
        Class a = String.class;
        Class b = "abc".getClass();
        Class c = null;
        try {
            c = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);


    }

}
