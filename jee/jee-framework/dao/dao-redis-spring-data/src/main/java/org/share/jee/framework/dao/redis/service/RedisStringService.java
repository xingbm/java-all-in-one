package org.share.jee.framework.dao.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by xingbm on 2021/2/27 17:53
 */
@Service
public class RedisStringService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String setget() {
        stringRedisTemplate.opsForValue().set("test", "111");
        return stringRedisTemplate.opsForValue().get("test");
    }

}
