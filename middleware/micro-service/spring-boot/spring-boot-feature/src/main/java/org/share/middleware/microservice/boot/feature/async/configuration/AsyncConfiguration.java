package org.share.middleware.microservice.boot.feature.async.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by xingbm on 2021/1/13 22:35
 */
@Configuration
public class AsyncConfiguration {

    private static final int MAX_POOL_SIZE = 5;
    private static final int CORE_POOL_SIZE = 2;

    @Bean("asyncTaskExecutor")
    public AsyncTaskExecutor asyncTaskExecutor() {
        ThreadPoolTaskExecutor asyncTaskExecutor = new ThreadPoolTaskExecutor();
        asyncTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        asyncTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        asyncTaskExecutor.setThreadNamePrefix("async-task-thread-pool-");
        asyncTaskExecutor.initialize();
        return asyncTaskExecutor;
    }

}
