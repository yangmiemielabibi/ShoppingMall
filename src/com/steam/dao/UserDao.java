package com.steam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.steam.bean.User;
import com.steam.util.Constant;
import com.steam.util.DBUtil;

public class UserDao {
	public List<User> Login(String userid , String password) {
		List<User> list = new ArrayList<User>();
		PreparedStatement st = null;
		ResultSet  rs = null;
		String sql = "SELECT * from " + Constant.UserTable + " where userid='"+userid+"' AND password='"+password+"'";
		st = DBUtil.getPreparedStatement(sql);
		try {
			rs = st.executeQuery();
			if(rs.next()) {
					User user = new User(); //实体类
					user.setAddressid(rs.getString("addressid"));
					user.setComment(rs.getString("commentid"));
					user.setCreatetime(rs.getString("createtime"));
					user.setHeadimg(rs.getString("headimg"));
					user.setHistoryid(rs.getString("historyid"));
					user.setModifytime(rs.getString("modifytime"));
					user.setOdersid(rs.getString("odersid"));
					user.setPassword(rs.getString("password"));
					user.setPhone(rs.getString("phone"));
					user.setPower(rs.getString("power"));
					user.setShopcatid(rs.getString("shopcatid"));
					user.setUserid(rs.getString("userid"));
					user.setUsername(rs.getString("username"));
					list.add(user);
			}
			else {
				System.out.println("查询不到符合条件的用户");
			}
		} catch (SQLException e) {
			System.out.println("查询用户失败");
			e.printStackTrace();
		}
		return list;
	}
}
