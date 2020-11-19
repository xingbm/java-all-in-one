package org.share.java.frame.design.reflect.base.constructor;

import java.lang.reflect.Constructor;

/**
 * Created by xingbm on 2020/11/2 21:30
 */
public class Demo01 {

    public static void main(String [] args) throws Exception {
        //获取字节码
        Class demo02 = Demo02.class;
        //获取私有构造器
        Constructor c = demo02.getDeclaredConstructor();
        //取消访问权限检查
        c.setAccessible(true);
        //执行构造器
        c.newInstance();
    }

}
