package PreTesting_Java_Collections;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaCollections_Map_Examples {	

	// WebDriver is not used here since There is no need to start an application
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		// There is no need to start an application
		String url1 = "https://www.lambdatest.com/selenium-playground/";
		//Setup(url);

		OperationsOnMapObject();
		
		// Nothing to quit, since it was not started
		//quitDriver();
	}
	
	// Since there is no need to start an application, this will not be called.
	public static void Setup(String url) {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	// Since there is Nothing to quit from, this will not be called
	public static void quitDriver() {
		driver.quit();
	}
	
	public static void OperationsOnMapObject() {
		// Create a HashMap object called capitalCities

		HashMap<String, String> capitalCities = new HashMap<String, String>();
		HashMap<String, String> studentInfo   = new HashMap<String, String>();
		
		// Add keys and values (Country, City)
		capitalCities.put("England", "London");
		capitalCities.put("Germany", "Berlin");
		capitalCities.put("Norway", "Oslo");
		capitalCities.put("USA", "Washington DC");
		
		// Add keys and values (studentID, studentName)
		studentInfo.put("101", "Adam");
		studentInfo.put("102", "John");
		studentInfo.put("103", "Jason");
		studentInfo.put("102", "Jill");
		
		// print the hashmap contents
		// 	printout appears in console as below:
		// 		{USA=Washington DC, Norway=Oslo, England=London, Germany=Berlin}
		//		{101=Adam, 102=Jill, 103=Jason}
		//	This means that the data entry order is not necessarily preserved when printing
		System.out.println(capitalCities);
		System.out.println(studentInfo);
		
		// add studentinfo to capabilities
		capitalCities.putAll(studentInfo);
		System.out.println(capitalCities);
		System.out.println("Info on Student: " + studentInfo.get("102"));
		studentInfo.remove("103");
		System.out.println(studentInfo);
		studentInfo.remove("101", "Adam");
		System.out.println(studentInfo);
		studentInfo.remove("102", "Ben");
		System.out.println(studentInfo);
		boolean exists = studentInfo.containsKey("102");
		System.out.println("Status: " + exists);
		System.out.println("Status: " + capitalCities.containsValue("London"));
		System.out.println(studentInfo);
		studentInfo.remove("102", "Jill");
		System.out.println(studentInfo);
		System.out.println("Status: " + studentInfo.isEmpty());
		studentInfo.put("102", "Jill");
		System.out.println("Status: " + studentInfo.isEmpty());
		System.out.println("Size = " + studentInfo.size());
		System.out.println("Size = " + capitalCities.size());
		capitalCities.clear();
		System.out.println("Size = " + capitalCities.size());
		// Add keys and values (Country, City)
		capitalCities.put("England", "London");
		capitalCities.put("Germany", "Berlin");
		capitalCities.put("England", "Oslo");
		capitalCities.put("USA", "Washington DC");
		capitalCities.put("France", "Berlin");
		System.out.println(capitalCities);
        System.out.println("The Key set is: " + capitalCities.keySet());
        System.out.println("The Values set is: " + capitalCities.values());
        System.out.println("The Entry set is: " + capitalCities.entrySet());
	}
}