package com.threewater.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 虞赟淼
 * @Date: 2022/03/08/13:11
 * @Description:
 */
public class JedisConnectionFactory {

    private static final JedisPool jedisPool;

    static {
        // 配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxIdle(8); // 最大空闲连接
        poolConfig.setMinIdle(0);
        poolConfig.setMaxWaitMillis(1000);
        // 创建连接池对象
        jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379, 1000, "abc036912");
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

}
