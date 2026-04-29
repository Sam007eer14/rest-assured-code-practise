package com.api.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HIkariCP_Demo {
	    public static void main(String[] args) throws SQLException{

	        HikariConfig hikariConfig = new HikariConfig();
	        hikariConfig.setJdbcUrl(ConfigManager2.getProperty("DB_URL"));
	        hikariConfig.setUsername(ConfigManager2.getProperty("DB_USER_NAME"));
	        hikariConfig.setPassword(ConfigManager2.getProperty("DB_PASSWORD"));
	        hikariConfig.setMaximumPoolSize(10);
	        hikariConfig.setMinimumIdle(2); // 1a
	        hikariConfig.setConnectionTimeout(10000); // 10 secs
	        hikariConfig.setIdleTimeout(10000);

	        HikariDataSource ds = new HikariDataSource(hikariConfig);
	        Connection conn = null;
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println(conn);
	        Statement statement = conn.createStatement();
	        ResultSet rs= statement.executeQuery("SELECT first_name, last_name, mobile_number from tr_customer;");
	        while(rs.next()) {
	        	System.out.println(rs.getString("first_name") + " " +  rs.getString("last_name") + " " + rs.getString("mobile_number"));
	        }
	        
	    }
	}

