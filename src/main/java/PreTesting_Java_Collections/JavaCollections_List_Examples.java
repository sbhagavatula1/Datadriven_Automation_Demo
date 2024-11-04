package PreTesting_Java_Collections;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaCollections_List_Examples {
		
	public static WebDriver driver;
		
	public static void main(String[] args) {
		String url1 = "https://money.rediff.com/gainers";
		String url2 = "https://www.naukri.com/";
		String url3 = "https://www.seleniumeasy.com/";
		String url4 = "file:///C:/Users/satya/Automation_from_Ramesh/OrangeHRM_SB/Data/HTMLTable.html";
		
		
		Setup(url1);
		FirstElement_of_TheSelectedRow();
		SelectedRowElements_Using_Iterator();
		SelectedRowElements_Using_EnhancedForLoop();
		IndividualElements_of_SelectedRow();
		RowsPreceding_TheSelectedRow();
		AllRows_of_dataTable_TableUsing_EnhancedForLoop();
		
		/*
			Setup(url4);
			// Printing table header of a web table assuming first row as header
			List<WebElement> ListOfHeadersOfTable = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[1]/th"));
			//List ListOfHeadersOfTable = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[1]/th"));
			System.out.println("Below are the Headers in table:");
			System.out.println("Total # of headers found: "+ ListOfHeadersOfTable.size());
			for(WebElement header:ListOfHeadersOfTable) {
				System.out.println(header.getText());
			}
		*/
		
		quitDriver();
	}
	public static void Setup(String url) {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	public static void quitDriver() {
		driver.quit();
	}
	public static void FirstElement_of_TheSelectedRow () {
		System.out.println("");
		// First item "Superior Finlease"of the row selected
		WebElement selectedRowCompanyColumn = driver.findElement(By.xpath("//a[contains(text(),'Superior Finlease')]//parent::td"));
		System.out.println("First element of the selected row:");
		System.out.println("\t" + selectedRowCompanyColumn.getText());
		System.out.println("");
	}
	public static void SelectedRowElements_Using_Iterator () {
		List<WebElement>     selectedRow = driver.findElements(By.xpath("//a[contains(text(),'Superior Finlease')]//parent::td//ancestor::tr"));
		Iterator<WebElement> itr1        = selectedRow.iterator();
		String               value1      = "";
		int                  i1          = 1;
		System.out.println("Selected Row Elements Using Iterator: (Number of Rows = " + selectedRow.size() + ")");
		while (itr1.hasNext()) {
			WebElement ele1 = itr1.next();
			value1 = ele1.getText();
			System.out.print("\t" + value1);
			i1++;
		}
		System.out.println("");
		System.out.println("");
	}
	public static void SelectedRowElements_Using_EnhancedForLoop () {
		List<WebElement> selectedRow1            = driver.findElements(By.xpath("//a[contains(text(),'Superior Finlease')]//parent::td//ancestor::tr"));
		System.out.println("Selected Row Elements Using Enhanced For Loop: (Number of Rows = " + selectedRow1.size() + ")");
		for(WebElement header:selectedRow1) {
			System.out.println("\t" + header.getText());
		}
		System.out.println("");
	}
	public static void IndividualElements_of_SelectedRow() {
		List<WebElement> selectedRow1            = driver.findElements(By.xpath("//a[contains(text(),'Superior Finlease')]//parent::td//ancestor::tr"));
		WebElement selectedRow1_Company          = driver.findElement(By.xpath("//a[contains(text(),'Superior Finlease')]"));
		WebElement selectedRow1_Group            = driver.findElement(By.xpath("//a[contains(text(),'Superior Finlease')]//following::td[1]"));
		WebElement selectedRow1_PrevClose_Rs     = driver.findElement(By.xpath("//a[contains(text(),'Superior Finlease')]//following::td[2]"));
		WebElement selectedRow1_CurrentPrice_Rs  = driver.findElement(By.xpath("//a[contains(text(),'Superior Finlease')]//following::td[3]"));
		WebElement selectedRow1_PercentChange    = driver.findElement(By.xpath("//a[contains(text(),'Superior Finlease')]//following::td[4]"));
		WebElement selectedRow1_TradeOnDhan_Buy  = driver.findElement(By.xpath("//a[contains(text(),'Superior Finlease')]//following::td[5]/a[text()='Buy']"));
		WebElement selectedRow1_TradeOnDhan_Sell = driver.findElement(By.xpath("//a[contains(text(),'Superior Finlease')]//following::td[5]/a[text()='Sell']"));
		
		System.out.println("Individual Elements of Selected Row");
		System.out.println("\t" + "Selected Row - Company          : " + selectedRow1_Company.getText());
		System.out.println("\t" + "Selected Row - Group            : " + selectedRow1_Group.getText());
		System.out.println("\t" + "Selected Row - PrevClose_Rs     : " + selectedRow1_PrevClose_Rs.getText());
		System.out.println("\t" + "Selected Row - CurrentPrice_Rs  : " + selectedRow1_CurrentPrice_Rs.getText());
		System.out.println("\t" + "Selected Row - PercentageChange : " + selectedRow1_PercentChange.getText());
		System.out.println("\t" + "Selected Row - TradeOnDhan_Buy  : " + selectedRow1_TradeOnDhan_Buy.getText());
		System.out.println("\t" + "Selected Row - TradeOnDhan_Sell : " + selectedRow1_TradeOnDhan_Sell.getText());
		System.out.println("");
	}
	public static void RowsPreceding_TheSelectedRow () {
		List<WebElement>     TopRowPrecedingselectedRow = driver.findElements(By.xpath("//a[contains(text(),'Superior Finlease')]//parent::td//ancestor::tr//preceding-sibling::tr"));
		//List<WebElement>   TopRowPrecedingselectedRow = driver.findElements(By.xpath("//a[contains(text(),'Superior Finlease')]//parent::td//parent::tr//preceding-sibling::tr"));
		Iterator<WebElement> itr2                       = TopRowPrecedingselectedRow.iterator();
		String               value2                     = "";
		int                  i2                         = 1;
		System.out.println("Rows preceding the selected row:");
		while (itr2.hasNext()) {
			WebElement ele2 = itr2.next();
			value2 = ele2.getText();
			System.out.println("\t" + value2);
			i2++;
		}
		System.out.println("");
	}
	public static void AllRows_of_dataTable_TableUsing_EnhancedForLoop () {
		List<WebElement> AllRows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody//tr"));
		System.out.println("All Rows in table:" + "(Number of Rows = " + AllRows.size() + ")");
		for(WebElement header:AllRows) {
			System.out.println("\t" + header.getText());
		}
		System.out.println("");
	}
}