package org.share.java.sa.datastructure.string.regex;

/**
 * Created by xingbm on 2020/11/19 7:15
 */
public class CharacterDemo {

    public static void main(String[] args) {

        // 1. 字符串是由3个字符组成：第一个字符只能从a/b/c,第二个字符只能由r/s/t,第三个字符是数字
        // [xyz] - 表示可以是x/y/z中的任何一个,[a-b] - 按照码表从a开始一直找到b
        /*String str = "ar1";
        System.out.println(str.matches("[abc][rst][0-9]"));*/

        // 2.判断一个字符串是否是由一个小写字母组成
        /*String str = "A";
        System.out.println(str.matches("[a-z]"));*/

        // 3. [^abc]表示除了a/b/c
        /*String str = "a1";
        System.out.println(str.matches("[^a-zA-Z]"));*/

        // 4.字符串由三个组成，第一个是字母，第二个是数字， “.”表示任意一个字符
        /*String str = "a6^";
        System.out.println(str.matches("[a-zA-Z][0-9]."));*/

        // 5.判断字符串是否只有一个字符
        /*String str = "1";
        System.out.println(str.matches("."));*/

        // 6.匹配. \\. 经过java编译就变成了\.，正则再转义成. 表示.
        /*String str = ".";
        System.out.println(str.matches("\\."));*/

        // 7.数量词
        String str = "dasfd";
        // a. {5}恰好有n次
        System.out.println(str.matches("[a-zA-Z]{5}"));
        // b. 至少由5个字母组成的字符串
        System.out.println(str.matches("[a-zA-Z]{4}[a-zA-Z]+"));
        System.out.println(str.matches("[a-zA-Z]{5,}"));
        // c.由6-12个字符组成
        System.out.println(str.matches(".{6,12}"));

    }

}
