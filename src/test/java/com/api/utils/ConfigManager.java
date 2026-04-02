package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
 

public class ConfigManager {
	
	
	private static Properties prop = new Properties();
	static {
	
		/*
		 * 	File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");
		 * We are going to add File.Seperator in the above code part and going to convert user friendly
		 */
		File file = new File(System.getProperty("user.dir") + File.separator +
		        "src" + File.separator +
		        "test" + File.separator +
		        "resources" + File.separator +
		        "config" + File.separator +
		        "config.properties");
		
	
		FileReader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	public String getProperty(String properValue) throws IOException {
		return prop.getProperty(properValue);
	
	}

}
