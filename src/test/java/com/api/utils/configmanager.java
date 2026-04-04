package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configmanager {
	private configmanager() {}
	private static Properties prop=new Properties();
	private static String path="config/config.properties";
	private static String env;
	static {
		// Read the properties from properties file in src/test/resources
		//load the properties file to the object
		env=System.getProperty("env","qa");
		env=env.toLowerCase().trim();
		
		switch(env) {
		case "qa": path="config/config.qa.properties";break;
		case "dev": path="config/configdev.properties";break;
		case "uat": path="config/config.uat.properties";break;
		default: path="config/config.qa.properties";
		}
		
		InputStream input=Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		if(input==null) {
			throw new RuntimeException("Cannot find this file at the path "+ path );
		}
		try {
			
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String getproperty(String key) throws IOException {

	return prop.getProperty("BASEURI");
	
}
}