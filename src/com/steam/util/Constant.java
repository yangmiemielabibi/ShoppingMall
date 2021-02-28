package com.steam.util;

public class Constant {
	public static String RequestCharacterEncoding = "utf-8"; //请求编码格式
	public static String ResponseCharacterEncoding = "text/json;charset=utf-8"; //响应编码格式
	public static String RedisIp = "106.52.112.29";
	public static int RedisHost = 6379;
	/**
	 * 数据库连接参数
	 */
	public static String DataBase ="shopmall";        //数据库名称
	public static String UserTable = "userinfo";      //用户数据表
	public static String AddressTable = "address";	  //收货地址表
	public static String ShopcartTable = "shopcart";  //购物车表
	public static String OrderTable = "orders";        //订单表
	public static String HistoryTable = "history";    //浏览记录表
	public static String EvaluateTable = "comment";  //评价表
	public static String GoodsTable = "goods";        //商品表
	public static String ParameterTable = "parameter";//商品参数
	public static String InfoTable = "info";          //资讯表
	
	public static String JDBC_Driver = "com.mysql.jdbc.Driver";  //驱动
	public static String DBURL = "jdbc:mysql://localhost:3306/" + DataBase +"?useSSL=false&characterEncoding=UTF-8";//url
	public static String DBUSER = "root"; //帐号
	public static String DBPWD = "yangyu8988625bxx"; //密码

}
