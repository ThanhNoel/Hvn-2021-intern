package com.nashtech.intern.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection connector;
	
	private String pathString = "jdbc:mysql://localhost:3306/intern_library";
	private String driverString = "com.mysql.jdbc.Driver";
	
	
	public DatabaseConnection() {
		if (connector == null)
		{
			try {
				Class.forName(driverString);
				connector = DriverManager.getConnection(pathString, "root", "hungtran");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
