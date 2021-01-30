package org.share.java.jvm.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * Created by xingbm on 2021/1/30 9:51
 */
public class JOLTest {

    public static synchronized Object test() {
        return new Object();
    }

    static void print(String message) {
        System.out.println(message);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        Object object = test();
        //查看对象内部信息
        print(ClassLayout.parseInstance(object).toPrintable());
        //查看对象外部信息
        print(GraphLayout.parseInstance(object).toPrintable());
        //获取对象总大小
        print("size : " + GraphLayout.parseInstance(object).totalSize());
    }

}
