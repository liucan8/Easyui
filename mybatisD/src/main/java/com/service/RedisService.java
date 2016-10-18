package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2016/9/1.
 */
@Service
public class RedisService {
    @Autowired
    private JedisPool jedisPool;
    public Jedis getResource() {
                 Jedis jedis = null;
                 try {
                         jedis = jedisPool.getResource();

                     } catch (Exception e) {
                        e.printStackTrace();
                     }
                 return jedis;
             }
}
