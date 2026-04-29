package com.api.tests.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.api.utils.ConfigManager2;

public class DataBaseManager {
	
	private static final String DB_URL=ConfigManager2.getProperty("DB_URL");
	private static final String DB_USER_NAME=ConfigManager2.getProperty("DB_USER_NAME");
	private static final String DB_PASSWORD = ConfigManager2.getProperty("DB_PASSWORD");
	public volatile static Connection con;
	private DataBaseManager() {
		
	}
	public  static void createConnection() {
		try {
			if(con==null) {
				synchronized (DataBaseManager.class) {
					if(con==null)  {
						 con = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);

					}
				}
				
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
