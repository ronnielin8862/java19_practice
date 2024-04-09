package org.example.config.shito;

import org.crazycake.shiro.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class RonnieRedisManager extends RedisManager {
    @Autowired
    RedisTemplate redisTemplate;
    public RonnieRedisManager(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    public byte[] get(String[] key) {
        return (byte[]) redisTemplate.opsForValue().get(key);
    }
}
