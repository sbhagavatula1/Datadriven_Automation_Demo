package com.orangeHRM_SB.utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "./Configuration/orangeHRM_SB.properties";
	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}
	public Properties init_prop() throws IOException{
		properties = new Properties();	
			String path = System.getProperty("user.dir") + "/Configuration/orangeHRM_SB.properties";
		try {
			FileInputStream file = new FileInputStream(path);	
			properties.load(file);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		return properties;
	}	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) {
			return driverPath;
		}
		else { 
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
		}
	}
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			return Long.parseLong(implicitlyWait);
		}
		else {
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
		}
	}
	public String getApplicationUrl() {
		//	url_NAL_cfg = https://naveenautomationlabs.com/opencart/index.php?route=account/login
		//String url = properties.getProperty("url_NAL_cfg");
		String url = properties.getProperty("url_SB_cfg");
		if(url != null) {
			return url;
		}
		else {
			throw new RuntimeException("url not specified in the Configuration.properties file.");
		}
	}
}