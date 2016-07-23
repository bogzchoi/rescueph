package com.hackanation.rescue;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	public Connection getConnection() throws Exception {
		try {
			String connectionURL = "jdbc:mysql://localhost:3306/mysql";
			Connection connection = null;
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "mySqlr0o+");
			return connection;
		} catch (Exception e) {
			throw e;
		}
	}

}
