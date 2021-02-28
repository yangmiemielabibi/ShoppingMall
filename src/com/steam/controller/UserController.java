package com.steam.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.steam.service.serviceimp.UserServiceImp;
import com.steam.util.Constant;
import com.steam.util.JsonChange;

public class UserController extends HttpServlet{
	UserServiceImp userServiceImp = new UserServiceImp();
	JsonChange print = new JsonChange();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding(Constant.RequestCharacterEncoding);
			String method = request.getParameter("method");
			String token = request.getHeader("token");
			token = token == null ? "" : token;	//若token 为null则转换为空字符串
			if("login".equals(method)) {
				String userid = request.getParameter("userid");
				String password = request.getParameter("password");
				token = userServiceImp.UserLogin(userid, password , token);
				print.change(response, token , true);
			}else if("getToken".equals(method)) {
				print.change(response, userServiceImp.GetUserToken(token) , true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
