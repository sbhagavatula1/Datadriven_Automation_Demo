package testNGOnePack;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Approach 2- You can find the dates using XPath or CSSSelector and 
 * click on the dates directly.
 */

public class CalendarHandling_MukeshOtwani_Approach2 {
	public static void main(String[] args) {
		// start firefox
		WebDriver driver=new FirefoxDriver();
		
		// start application
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		// click on date picker so that we can get the calendar in view
		driver.findElement(By.id("datepicker")).click();
		
		// this will find all matching nodes in calendar
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		// Click on date 28 or any other date of your choice
		driver.findElement(By.xpath("//a[text()='28']")).click();
		
		driver.quit();
	}
}