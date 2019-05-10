package com.example.redisdemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetSetServiceTest {

    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public GetSetServiceTest(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Before
    public void beforeEach() {

    }

    @Test
    public void testSet() {

    }

    @Test
    public void testGet() {

    }
}