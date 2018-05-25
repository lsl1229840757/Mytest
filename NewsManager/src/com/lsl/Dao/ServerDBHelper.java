package com.lsl.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ServerDBHelper {

	static String url;
	static Properties pro = new Properties();

	static {
		// 获得配置文件的输入流
		InputStream in = ServerDBHelper.class.getClassLoader().getResourceAsStream("com/lsl/Dao/config.properties");

		try {
			pro.load(in);
			// 开始加载驱动
			String driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			System.out.println(url);
			Class.forName(driver);
			System.out.println("成功");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("加载失败");
		}

	}

	// 开始连接数据库
	public static Connection getConnection() throws SQLException {
		
		Connection con = DriverManager.getConnection(url, pro);
		return con;
	}
	
}
