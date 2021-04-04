package org.share.jee.framework.dao.redis;

import org.junit.jupiter.api.Test;
import org.share.jee.framework.dao.redis.service.RedisStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisStringServiceTests {

    @Autowired
    private RedisStringService redisStringService;

    @Test
    public void setget() {
        System.out.println(redisStringService.setget());
    }

}
