package PreTesting_orangeHRM;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com. orangeHRM_SB.pages.LoginPage;
import com.orangeHRM_SB.utilities.Screenshot;
import com.orangeHRM_SB.actions.driverManager;

@Listeners(com.orangeHRM_SB.customeListener.Log.class)
public class employeeSearchTest extends driverManager {
	
	LoginPage loginPage;
	//PIMPage pimpage;
	@BeforeTest
	public void startup() throws IOException, InterruptedException{
		initDriver();
		//getDriver().get(prop.getProperty("AppUrl"));
		getDriver().get(prop.getProperty("url_SB_cfg"));
		getDriver().manage().window().maximize();
        //Thread.sleep(4000);
	}
	@Test
	public void selectEmployeeFromList() throws InterruptedException{
		
		loginPage = new LoginPage(getDriver());
		Screenshot.testName="Login";
        
		loginPage.Username("Admin");
		loginPage.Password("admin123");
		
		loginPage.clickOnLogin();
		Thread.sleep(5000);
		
		/*
		Screenshot.testName="PIM";
		loginPage.clickOnPIM();
		Thread.sleep(2000);

		loginPage.verifyPIMText();	
		pimpage =new PIMPage(getDriver());
		Screenshot.testName="PIM";
		Thread.sleep(3000);

		pimpage.employeeSearch("0070");
		Thread.sleep(3000);
		*/
	}
}