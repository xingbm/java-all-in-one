package org.share.middleware.microservice.boot.dependence.demo;

import org.share.middleware.microservice.boot.dependence.demo.child.DemoUtil;

/**
 * Created by xingbm on 2020/11/2 20:39
 */
public class InvokingChildDependenceDemo {

    public static void main(String[] args) {
        DemoUtil.getDependenceName();
    }

}
