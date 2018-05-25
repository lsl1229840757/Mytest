package com.lsl.Dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ClientDBHelper {

	public static Connection getConnection() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/lsl");
			Connection con = ds.getConnection();
			return con;
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
