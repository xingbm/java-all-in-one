package org.share.middleware.microservice.boot.feature.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by xingbm on 2021/1/13 22:27
 */
@Service
public class TestServiceImpl implements TestService {

    @Async
    @Override
    public void asyncTask() {
        System.out.println("async running,threadName:" + Thread.currentThread().getName());
    }

}
