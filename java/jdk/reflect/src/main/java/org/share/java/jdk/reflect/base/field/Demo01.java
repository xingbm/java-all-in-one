package org.share.java.jdk.reflect.base.field;

import java.lang.reflect.Field;

/**
 * Created by xingbm on 2020/11/2 21:46
 */
public class Demo01 {

    public static void main(String [] args) throws Exception {
        Class dclass = Demo02.class;
        //获取XXX成员变量
        Field xxx = dclass.getDeclaredField("XXX");
        //实例一个demo
        Demo02 demo02 = new Demo02();
        //去掉权限验证（暴力反射）
        xxx.setAccessible(true);
        //获取这个属性的值
        System.out.println(xxx.get(demo02));
        //修改demo02的XXX属性
        if(xxx.getType()==String.class){
            xxx.set(demo02,"good good study");
        }
        System.out.println(xxx.get(demo02));
    }

}
