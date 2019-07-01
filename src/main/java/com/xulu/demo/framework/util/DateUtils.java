package com.xulu.demo.framework.util;

import redis.clients.jedis.JedisCluster;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static String formatDateTime(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static void main(String[] args) {
        JedisCluster jedis = RedisClusterUtil.getJedis();
        jedis.set("cluster", "hello");
        System.out.println(jedis.get("cluster"));
    }


}
