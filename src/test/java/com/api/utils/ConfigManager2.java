package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class ConfigManager2 {
	private static Properties prop = new Properties();
	static {
	InputStream load = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/config.properties");
	if(load == null) {
		throw new RuntimeException("Cannot find the InputStream Value" + load);
	}
		try {
			prop.load(load);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	public static String getProperty(String properValue){
		return prop.getProperty(properValue);
	
	}
}
