package com.zy.minicoderedis.common;

import com.alibaba.fastjson.JSON;
import com.zy.minicoderedis.lock.lock.RedisLock;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;

/**
 * @author: zhengyao
 * @date: 2020/4/29 20:49
 */
@Component
public class RedisService {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    private static final Long RELEASE_SUCCESS = 1L;

    @Autowired
    JedisPool jedisPool;

    //设置对象
    public <T> Boolean set(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = beanToString(value);

            if (StringUtils.isEmpty(str)) return false;
            //生成真正的key
            String realKey = prefix.getPrefix() + key;
            int seconds = prefix.expireSeconds();
            if (seconds <= 0) {
                jedis.set(realKey, str);
            } else {
                jedis.setex(realKey, seconds, str);
            }
            return true;
        } finally {
            returnToPool(jedis);
        }

    }

    /**
     * 尝试获取分布式锁
     * @return 是否获取成功
     *
     * 网上的写法
     * public static Long setnx(String key, String value){
     *         Jedis jedis = null;
     *         Long result = null;
     *         try {
     *             jedis = RedisPool.getJedis();
     *             result = jedis.setnx(key, value);
     *         } catch (Exception e){
     *             e.printStackTrace();
     *         } finally {
     *             if (jedis != null) {
     *                 jedis.close();
     *             }
     *             return result;
     *         }
     *     }
     *     这是有问题的，当redis挂了，会导致死锁
     */
    public Boolean setNx(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            int expireTime = prefix.expireSeconds();
            String realkey = prefix.getPrefix() + key;

            String result = jedis.set(realkey, key, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

            if (LOCK_SUCCESS.equals(result)) {
                return true;
            }
            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    public Boolean releaseDistributedLock(KeyPrefix prefix, String lockName) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            String realkey = prefix.getPrefix() + lockName;
            //lua脚本
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Object result = jedis.eval(script, Collections.singletonList(realkey),Collections.singletonList(lockName));

            if (RELEASE_SUCCESS.equals(result)) {
                return true;
            }
            return true;
        } finally {
            returnToPool(jedis);
        }
    }


    //获取
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String realKey = prefix.getPrefix() + key;
            String str = jedis.get(realKey);
            T t = stringToBean(str, clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }
    }

    //判断key是否存在
    public <T> boolean exists(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String realKey = prefix.getPrefix() + key;
            return jedis.exists(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    //增加值
    public <T> Long incr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String realKey = prefix.getPrefix() + key;
            return jedis.incr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    //减少值
    public <T> Long decr(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String realKey = prefix.getPrefix() + key;
            return jedis.decr(realKey);
        } finally {
            returnToPool(jedis);
        }
    }

    //stringToBean
    public static <T> T stringToBean(String str, Class<T> clazz) {
        if (StringUtils.isEmpty(str) || clazz == null) return null;

        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        } else if (clazz == String.class) {
            return (T) str;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(str);
        } else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }


    //benaToString
    public static <T> String beanToString(T value) {
        if (value == null) return null;

        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }


}
