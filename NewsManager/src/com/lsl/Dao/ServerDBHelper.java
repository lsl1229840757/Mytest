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
		// ��������ļ���������
		InputStream in = ServerDBHelper.class.getClassLoader().getResourceAsStream("com/lsl/Dao/config.properties");

		try {
			pro.load(in);
			// ��ʼ��������
			String driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			System.out.println(url);
			Class.forName(driver);
			System.out.println("�ɹ�");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("����ʧ��");
		}

	}

	// ��ʼ�������ݿ�
	public static Connection getConnection() throws SQLException {
		
		Connection con = DriverManager.getConnection(url, pro);
		return con;
	}
	
}
