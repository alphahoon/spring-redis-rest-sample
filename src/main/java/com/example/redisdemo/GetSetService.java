package com.example.redisdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class GetSetService {

    private static final Logger log = LoggerFactory.getLogger(GetSetService.class);

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public GetSetService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Object set(String key, Object value) {
        ValueOperations<String, Object> vop = redisTemplate.opsForValue();
        vop.set(key, value);
        Object result = vop.get(key);
        log.info("GetSetService/set " + key + " : " + result);

        return result;
    }

    public Object get(String key) {
        ValueOperations<String, Object> vop = redisTemplate.opsForValue();
        Object result = vop.get(key);
        log.info("GetSetService/get" + key + " : " + result);

        return result;
    }
}
