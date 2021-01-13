package org.share.middleware.microservice.boot.feature.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by xingbm on 2021/1/13 21:54
 */
@Component
public class TestImplCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("这个是测试CommandLineRunn接口");
    }

}
