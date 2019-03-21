package test1;


import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class Test2 {
	public static void main(String[] args) {
		Jedis j = new Jedis("192.168.126.138",6379);
		System.out.println(j.ping());
		j.set("k1","vvvvvv1");
		System.out.println(j.get("k1"));
	}
}
