package org.share.middleware.microservice.boot.feature.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by xingbm on 2021/1/13 21:55
 */
@Component
public class TestImplApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("这是测试ApplicationRunner接口");
    }

}
