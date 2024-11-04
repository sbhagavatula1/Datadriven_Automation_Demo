package testNGOnePack;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DateTimePicker_Guru99 {
	
	WebDriver driver = null;
	@Test
	public void dateTimePicker() {
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//Find the date time picker control
		WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));
		
		//Fill date as mm/dd/yyyy as 09/25/2013
		dateBox.sendKeys("09252013");
		
		//Press tab to shift focus to time field
		dateBox.sendKeys(Keys.TAB);
		
		//Fill time as 02:45 PM
		dateBox.sendKeys("0245PM");
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}