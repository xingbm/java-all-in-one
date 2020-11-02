package org.share.middleware.microservice.boot.dependence.demo.maven.module.web;

import org.share.middleware.microservice.boot.dependence.demo.maven.module.service.DemoUtil;

/**
 * Created by xingbm on 2020/11/2 21:15
 */
public class InvokingServiceDemo {

    public static void main(String[] args) {
        DemoUtil.getServiceName();
    }

}
