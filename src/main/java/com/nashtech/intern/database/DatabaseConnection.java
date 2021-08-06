package com.nashtech.intern.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection connector;
	
	public DatabaseConnection() {
		if (connector == null)
		{
			String pathString = "jdbc:mysql://localhost:3306/intern_library?autoReconnect=true&useSSL=false";
			String driverString = "com.mysql.jdbc.Driver";
			
			try {
				Class.forName(driverString);
				connector = DriverManager.getConnection(pathString, "root", "hungtran");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
