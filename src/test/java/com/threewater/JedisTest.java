package com.threewater;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 虞赟淼
 * @Date: 2022/03/08/10:57
 * @Description:
 */
public class JedisTest {

    private Jedis jedis;

    @BeforeEach
    public void setJedis() {
        // 创建Jedis对象
        jedis = new Jedis("127.0.0.1", 6379);
        // 设置密码
        jedis.auth("abc036912");
        // 选择库
        jedis.select(0);
    }

    @Test
    public void testString() {
        // 存入数据
        String result = jedis.set("name", "呵呵");
        System.out.println("result = " + result);
        // 获取数据
        String name = jedis.get("name");
        System.out.println("name = " + name);
    }

    @Test
    public void testHash() {
        // 插入hash数据
        jedis.hset("user:1", "name", "yym");
        jedis.hset("user:1", "age", "16");
        // 获取
        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);
    }

    @AfterEach
    public void tearDown() {
        // 释放资源
        if (jedis != null) {
            jedis.close();
        }
    }

}
