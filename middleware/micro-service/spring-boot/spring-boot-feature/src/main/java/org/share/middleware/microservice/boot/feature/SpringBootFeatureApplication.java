package org.share.middleware.microservice.boot.feature;

import org.share.middleware.microservice.boot.feature.async.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringBootFeatureApplication {

    @Autowired
    private TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFeatureApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return applicationArguments -> {
            testService.asyncTask();
        };
    }

}
