package org.share.jee.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
//@EnableAspectJAutoProxy(exposeProxy = true)
public class JeeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeeWebApplication.class, args);
    }

}
