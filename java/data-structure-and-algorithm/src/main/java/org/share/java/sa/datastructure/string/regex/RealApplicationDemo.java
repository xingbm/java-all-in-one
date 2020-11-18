package org.share.java.sa.datastructure.string.regex;

/**
 * Created by xingbm on 2020/11/19 7:17
 */
public class RealApplicationDemo {

    public static void main(String[] args) {
        //replace();
        //split();
        String str = "Cat Dog";
        //将cat和dog的位置进行颠倒
        //在替换过程中，\n的形式不起作用
        //在替换过程中，如果想要引用上一个捕获组，那么需要使用$n的形式
        System.out.println(str.replaceAll("(Cat)(.*)(Dog)", "$3$2$1"));
        String str1 = "我我我我爱爱学学学学习习";
        System.out.println(str1.replaceAll("(.)\\1+", "$1"));
    }

    private static void replace() {
        String str = "asfsafasf12sad17--";
        //将字符串所有的数字替换为-
        System.out.println(str.replaceAll("\\d", "-"));
        //将字符串中的所有的数字去掉
        System.out.println(str.replaceAll("\\d", ""));
        //所有非数字去掉
        System.out.println(str.replaceAll("\\D", ""));
    }

    //TODO 分割后为什么会有空
    private static void split() {
        String str = "40asfas40as1fasdcer4";
        //以数字为切割符将字符串切割成多个子串,作为切割符的字符会被整个切掉,如果切割符在字符串的尾部，会被直接切掉
        String[] arr = str.split("\\d");
        System.out.println(arr.length);
        for(String s : arr) {
            System.out.println(s);
        }
    }

}
