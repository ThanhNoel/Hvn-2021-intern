package com.nashtech.intern.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class GenericDAO {

public static Connection con;
	
	public GenericDAO(){
		if(con == null){
			String dbUrl = "jdbc:mysql://localhost:3306/thuc_tap?autoReconnect=true&useSSL=false";
			String dbClass = "com.mysql.cj.jdbc.Driver";
			try {
				Class.forName(dbClass);
				con = DriverManager.getConnection (dbUrl, "root", "kieuvanthong98");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
