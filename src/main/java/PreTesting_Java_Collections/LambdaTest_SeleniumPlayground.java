package PreTesting_Java_Collections;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LambdaTest_SeleniumPlayground {	

	public static WebDriver driver;
	
	// https://video.search.yahoo.com/search/video?fr=mcafee&p=lambda+test+playground&type=E210US105G0#id=3&vid=cea53bc68dae84bf42d2e3ad7ed288cf&action=click
	public static void main(String[] args) {
		String url1 = "https://www.lambdatest.com/selenium-playground/";
		
		Setup(url1);
		quitDriver();
		
		BootstrapListBox();
		CheckBoxDemo();
		DragAndDropSliders();
		GeoLocationTesting();
		JavascriptAlerts();
		JQuerySelectDropdown();
		ProgressiveBarModal();
		ShadowDOM();
		TableDataSearch();
		UploadFileDemo();
		AutoHealing();
		BootstrapModals();
		ContextMenu();
		DragAndDrop();
		HoverDemo();
		JQueryDatePicker();
		KeyPress();
		RadioButtonsDemo();
		SimpleFormDemo();
		TableFilter();
		VirtualDOM();
		BootstrapAlerts();
		BootstrapProgressBar();
		DataListFilter();
		DynamicDataLoading();
		iFrameDemo();
		JQuertDownloadProgressBars();
		NestedBars();
		Redirection();
		StatusCodes();
		TablePagination();
		WindowPopupModal();
		BootstrapDatePicker();
		BrokenImage();
		DownloadFileDemo();
		FileDownload();
		InputFormSubmit();
		JQueryListBOX();
		OverLappedElement();
		SelectDropdownList();
		TableDataDOWNLOAD();
		TableSortAndScratch();		
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
	public static void BootstrapListBox() {
		
	}
	public static void CheckBoxDemo() {
		
	}
	public static void DragAndDropSliders() {
		
	}
	public static void GeoLocationTesting() {
		
	}
	public static void JavascriptAlerts() {
		
	}
	public static void JQuerySelectDropdown() {
		
	}
	public static void ProgressiveBarModal() {
		
	}
	public static void ShadowDOM() {
		
	}
	public static void TableDataSearch() {
		
	}
	public static void UploadFileDemo() {
		
	}
	public static void AutoHealing() {
		
	}
	public static void BootstrapModals() {
		
	}
	public static void ContextMenu() {
		
	}
	public static void DragAndDrop() {
		
	}
	public static void HoverDemo() {
		
	}
	public static void JQueryDatePicker() {
		
	}
	public static void KeyPress() {
		
	}
	public static void RadioButtonsDemo() {
		
	}
	public static void SimpleFormDemo() {
		
	}
	public static void TableFilter() {
		
	}
	public static void VirtualDOM() {
		
	}
	public static void BootstrapAlerts() {
		
	}
	public static void BootstrapProgressBar() {
		
	}
	public static void DataListFilter() {
		
	}
	public static void DynamicDataLoading() {
		
	}
	public static void iFrameDemo() {
		
	}
	public static void JQuertDownloadProgressBars() {
		
	}
	public static void NestedBars() {
		
	}
	public static void Redirection() {
		
	}
	public static void StatusCodes() {
		
	}
	public static void TablePagination() {
		
	}
	public static void WindowPopupModal() {
		
	}
	public static void BootstrapDatePicker() {
		
	}
	public static void BrokenImage() {
		
	}
	public static void DownloadFileDemo() {
		
	}
	public static void FileDownload() {
		
	}
	public static void InputFormSubmit() {
		
	}
	public static void JQueryListBOX() {
		
	}
	public static void OverLappedElement() {
		
	}
	public static void SelectDropdownList() {
		
	}
	public static void TableDataDOWNLOAD() {
		
	}
	public static void TableSortAndScratch() {
		
	}	
}