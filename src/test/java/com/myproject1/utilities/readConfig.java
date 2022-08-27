package com.myproject1.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
 
	Properties properties;
	String path = "D:\\My Project\\MyProject1\\Configuration\\config.properties";

	// Constructor
	public readConfig() {
		try {
			properties = new Properties();

			FileInputStream fis = new FileInputStream(path);
			properties.load(fis); // load file
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 public String  getbaseURL() {
	String value = properties.getProperty("baseURL");
	if ( value != null)
		return value;
	else 
		throw new RuntimeException("URL not specified in config file");
 }
 
 public String  getBroswer() {
	String value = properties.getProperty("browser");
	if ( value != null)
		return value;
	else 
		throw new RuntimeException("Browser not specified in config file");
 }
 
 
} 
