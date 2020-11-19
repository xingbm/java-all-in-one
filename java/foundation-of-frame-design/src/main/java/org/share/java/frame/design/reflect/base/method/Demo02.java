package org.share.java.frame.design.reflect.base.method;

/**
 * Created by xingbm on 2020/11/2 21:33
 */
public class Demo02 {

    private String secretFunc(String name,String desc) {
        System.out.println(name);
        System.out.println(desc);
        return name + "做了一把" + desc;
    }

}
