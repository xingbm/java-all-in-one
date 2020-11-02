package org.share.java.jdk.reflect.base.method;

import java.lang.reflect.Method;

/**
 * Created by xingbm on 2020/11/2 21:33
 */
public class Demo01 {

    public static void main(String [] args) throws Exception {
        Class dclass = Demo02.class;
        //获取secretFunc方法
        Method method = dclass.getDeclaredMethod("secretFunc",String.class,String.class);
        //实例一个demo02
        Demo02 demo02 = new Demo02();
        //去掉权限验证（暴力反射）
        method.setAccessible(true);
        //执行demo02的secretFunc方法,并获得返回值
        String result = (String) method.invoke(demo02,"罗永浩","锤子");
        //输出结果
        System.out.println(result);
    }

}
