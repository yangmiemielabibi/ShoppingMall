package com.steam.service.serviceimp;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

import com.steam.bean.User;
import com.steam.dao.UserDao;
import com.steam.util.TokenUtil;
import com.team.service.IUser;

import redis.clients.jedis.Jedis;

public class UserServiceImp implements IUser{
	private UserDao userDao;
	public String UserLogin(String userid , String password , String token) {
		userDao = new UserDao();
		List<User> list = userDao.Login(userid, password);
		if(!list.isEmpty()) {	//登陆成功
			User user = list.get(0);
			token = TokenUtil.initToken(user , token) + "";
			return token;
		}else {
			System.out.println("登陆失败");
			return "";
		}
	}
	
	public String GetUserToken(String token) {
		return TokenUtil.CheckUser(token);
	}
	
}
