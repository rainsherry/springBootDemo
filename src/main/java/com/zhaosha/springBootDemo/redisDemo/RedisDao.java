package com.zhaosha.springBootDemo.redisDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by rainsherry on 2018/5/31.
 */
@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate template;

    public void setKey(String key, String value) {
        template.opsForValue().set(key, value);
    }

    public String getValue(String key) {
        return template.opsForValue().get(key);
    }
}
