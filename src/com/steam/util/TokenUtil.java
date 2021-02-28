package com.steam.util;

import java.util.UUID;

import com.steam.bean.User;

import redis.clients.jedis.Jedis;

public class TokenUtil {
	public static Jedis jedis = new Jedis(Constant.RedisIp , Constant.RedisHost);	//第一个参数为ip地址
	public static String initToken(User user , String token) {
		//生成Token令牌
		if(token.equals("")) {
			token = UUID.randomUUID() + "";
		}
		//存到redis数据库
		if(CheckUser(token) == "") {	//若redis中该token不存在
			jedis.set(token, user.getUserid());	//第一个参数为Token令牌，第二个参数为该用户的userid;
			jedis.expire(token, 1800);	//过期时间设置为半小时
		}else {
			resetExpire(token);		
		}
		return token;
	}
	
	public static void deleteToken(String token) {
		jedis.del(token);
	}
	
	public static void resetExpire(String token) {
		jedis.expire(token, 1800);	//重置过期时间
	}
	
	public static String CheckUser(String token) {
		if(jedis.get(token) == null) {
			return "";
		}
		return jedis.get(token);
	}
}
