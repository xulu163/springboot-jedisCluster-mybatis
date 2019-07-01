package com.xulu.demo.framework.util;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import java.util.HashSet;
import java.util.Set;

/**
 * jedisCluster
 *
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-01 18:31
 **/
public class RedisClusterUtil {

    private static JedisCluster jedis = null;

    private static Integer MAX_TOTAL = 1024;

    private static Integer MAX_IDLE = 200;

    private static Integer MAX_WAIT_MILLIS = 10000;

    private static Boolean TEST_ON_BORROW = true;

    private static Boolean TEST_WHILE_IDLE = true;

    private static Boolean TEST_ON_RETURN = true;

    private static String AUTH = "";

    static {
        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxTotal(MAX_TOTAL);
        config.setMaxIdle(MAX_IDLE);
        config.setMaxWaitMillis(MAX_WAIT_MILLIS);
        config.setTestOnBorrow(TEST_ON_BORROW);
        config.setTestOnReturn(TEST_ON_RETURN);
        config.setTestWhileIdle(TEST_WHILE_IDLE);

        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort("192.168.1.5", 7000));
        jedisClusterNode.add(new HostAndPort("192.168.1.7", 7000));
        jedisClusterNode.add(new HostAndPort("192.168.1.8", 7000));

        jedis = new JedisCluster(jedisClusterNode, 1000, 1000, 5, null,config);
    }

    public static JedisCluster getJedis(){
        return jedis;
    }


}
