package org.share.java.sa.datastructure.string.regex;

/**
 * Created by xingbm on 2020/11/19 7:17
 */
public class CapturingGroupDemo {

    public static void main(String[] args) {

        //(.)\\1+ 表示叠字
        String str1 = "娃哈哈";
        System.out.println(str1.matches(".*(.)\\1+.*"));

        //AABB 高高兴兴
        String str2 = "高高兴兴";
        System.out.println(str2.matches(".*(.)\\1(.)\\2.*"));

        //abab 休息休息 （..）任意两个字符
        String str3 = "休息休息";
        System.out.println(str3.matches("(..)\\1"));

    }

}
