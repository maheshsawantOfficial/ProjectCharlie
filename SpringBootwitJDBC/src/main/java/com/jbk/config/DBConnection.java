package com.jbk.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ojtdec", "root", "root");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		return connection;

	}

}
