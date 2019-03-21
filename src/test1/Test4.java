package test1;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

public class Test4 {
	public static volatile JedisPool jp;

	public static JedisPool getJP() {
		if (jp == null) {
			synchronized (Test4.class) {
				if (jp == null) {
					JedisPoolConfig poolConfig = new JedisPoolConfig();
					poolConfig.setMaxActive(300);
					poolConfig.setMaxIdle(32);
					poolConfig.setMaxWait(100 * 1000);
					poolConfig.setTestOnBorrow(true);
					jp = new JedisPool(poolConfig, "192.168.126.147", 6379);

				}
			}
		}
		return jp;
	}

	public static void main(String[] args) {
		Jedis j = Test4.getJP().getResource();
		System.out.println(j.ping());
		Test4.getJP().returnResourceObject(j);

		System.out.println(j.get("k1"));
	}
}
