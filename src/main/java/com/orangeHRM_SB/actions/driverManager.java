package com.orangeHRM_SB.actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverManager {

	public  WebDriver driver;
	public  Properties prop;

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	/**
	 * This method is used to initialize the thradlocal driver on the basis of
	 * browser from config file
	 * 
	 * @return this will return tldriver.
	 */
	public WebDriver initDriver() throws IOException {
		prop                     = new Properties();
		String          filePath = System.getProperty("user.dir") + "/Configuration/orangeHRM_SB.properties";
		FileInputStream fis      = new FileInputStream(filePath);
						
		prop.load(fis);
						
		String browserCfg = prop.getProperty("browser_SB_cfg");
		if (browserCfg.toUpperCase().equals("CHROME")) {
			ChromeOptions options=new ChromeOptions();
			Map<String, Object> prefs=new HashMap<String,Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			//1-Allow, 2-Block, 0-default
			options.setExperimentalOption("prefs",prefs);
			tlDriver.set(new ChromeDriver(options)); // Selenium manager function is included in the "set" method
		}
		else if (browserCfg.toUpperCase().equals("FIREFOX")) {
			tlDriver.set(new FirefoxDriver());
		}
		else if (browserCfg.toUpperCase().equals("EDGE")) {
			tlDriver.set(new EdgeDriver());
		}
		else {
			System.out.println("Please pass the correct browset vlaue:"+ browserCfg);
		}		
		
		return driver;
	}

	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser parameter
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browserParam) {

		System.out.println("browser value is:" + browserParam);

		if(browserParam.toUpperCase().equals("CHROME")) {
			tlDriver.set(new ChromeDriver());
		}
		else if(browserParam.toUpperCase().equals("FIREFOX")) {
			tlDriver.set(new FirefoxDriver());
		}
		else if(browserParam.toUpperCase().equals("EDGE")) {
			tlDriver.set(new EdgeDriver());
		}
		else if(browserParam.toUpperCase().equals("OPERA")) {
			//tlDriver.set(new OperaDriver());
		}
		else {
			System.out.println("Please pass the correct browset vlaue: "+ browserParam);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}