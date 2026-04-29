package com.api.tests.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
public class JDCB_Demo {
	public static void main(String[] args) {
		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://64.227.160.186:3306/SR_DEV", "srdev_ro_automation", "Srdev@123");
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT first_name, last_name, mobile_number from tr_customer;");
			
			while(resultSet.next()) {
				String first_name = resultSet.getString("first_name");
				String last_name = resultSet.getString("first_name");
				String mobile_number = resultSet.getString("first_name");
                System.out.println(first_name+"|"+last_name+"|"+mobile_number);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
