package org.share.java.sa.datastructure.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xingbm on 2020/11/19 7:02
 */
public class Demo {

    //TODO 规范
    public static void main(String[] args) {
        String str = "abc";
        //指定校验格式
        Pattern pattern = Pattern.compile("abc");
        //将当前的规则和判断字符串进行匹配
        Matcher matcher = pattern.matcher(str);
        //进行判断
        boolean b = matcher.matches();
        System.out.println(b);

    }

}
