package org.share.java.jdk.reflect.base.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by xingbm on 2020/10/30 8:09
 */
public class ConstructorDemo {

    public static void main(String[] args) {
        Class strcla = null;
        try {
            strcla = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
        }
        // 获取所有的类的构造器
        Constructor[] acs = strcla.getConstructors();
        // 获取参数是StringBuffer的构造器
        Constructor ac = null;
        try {
            ac = strcla.getConstructor(StringBuffer.class);
        } catch (NoSuchMethodException e) {
        }
        // 利用构造器，创建对象
        String a = null;
        try {
            a = (String) ac.newInstance(new StringBuffer("666"));
        } catch (InstantiationException|IllegalAccessException| InvocationTargetException e) {
        }
        System.out.println(a);
    }

}
