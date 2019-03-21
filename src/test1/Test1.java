package test1;


import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class Test1 {
	public static void main(String[] args) {
		Jedis j = new Jedis("192.168.126.148",6379);
		System.out.println(j.ping());
		System.out.println(j.get("k1"));
		//j.set("k4","value4");
		//j.set("k5","value5");
		//System.out.println(j.info());
		Set<String> keys  = j.keys("*");
		for(String k : keys){
			System.out.println(k);
		}
		
		j.watch("k1");
		Transaction tx = j.multi();
		tx.set("k1","kkk1");
		tx.set("k2","kkk2");
		tx.set("k3","kk3k");
		
		List results =  tx.exec();
		for(Object o : results){
			System.out.println(o);
		}
		j.unwatch();
		//System.out.println(tx.discard());
		System.out.println("ok test~");
	}
}
