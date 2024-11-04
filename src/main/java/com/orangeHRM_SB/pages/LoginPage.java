package com.orangeHRM_SB.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.orangeHRM_SB.actions.orangeHRM_SB_Actions;
import com.orangeHRM_SB.utilities.ConfigFileReader;

public class LoginPage extends orangeHRM_SB_Actions{
	
	public WebDriver driver;
	ConfigFileReader configFileReader;
	
	public LoginPage(WebDriver driver){
		super(driver);
		this.driver =driver;
		configFileReader = new ConfigFileReader();
	}
	
    By UserNameTxtBox                 = By.name("username");
    By PassWordTxtBox                 = By.name("password");
    By LoginBtn                       = By.xpath("//button[@type='submit']");
	
    //By dashBoardTitle               = By.xpath("//div[@class='oxd-topbar-header-title']/span/h6");
    By pim                            = By.xpath("//div[@class='oxd-topbar-header']//div[1]");
    
    By forgotPasswordLink             = By.xpath("//p[text()='Forgot your password? ']");
    By invalidCredentialsErrorMessage = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
    By missingUsernameMessage         = By.xpath("//label[text()='Username']//parent::div//parent::div/span");
    By missingPasswordMessage         = By.xpath("//label[text()='Password']//parent::div//parent::div/span");
	By alertMessage                   = By.cssSelector("div[class='oxd-alert oxd-alert--error']");
	By fieldAlert                     = By.cssSelector("span[class*='oxd-input-field-error-message']");
	
	public void Username(String text){
		writeText(UserNameTxtBox, text, "UsernameTextBox");
	}
	public void Password(String text){
		//writeText(Password, text);
		writeText(PassWordTxtBox, text, "PasswordTextBox");
	}
	public void clickOnLogin(){
		waitToElementLoad(5);
		click(LoginBtn, "Login Button");
		//javaScriptClick(LoginBtn, "Click on the Login Button", "LoginButton");
	}
	public void loginApplication(String username, String password){
		writeText(UserNameTxtBox, username, "UsernameTextBox");
		writeText(PassWordTxtBox, password, "PasswordTextBox");
		javaScriptClick(LoginBtn, "Click on the Login Button", "LoginButton");
	}
	public void verifyDashBoardText()
	{
		String actual = getText(pim, "DashBoard");
		Assert.assertEquals(actual, "Dashboard");		
	}
	public String verifyTheAlertMessage(String expectedMsg) {	
		String alertMsg = readText(alertMessage, "alert message");
		Assert.assertEquals(alertMsg, expectedMsg);	
		return alertMsg;
	}
    public String verifyFieldAlertMessage(String expectedMsg) {
		String alertMsg = readText(fieldAlert, "field alert message");
		Assert.assertEquals(alertMsg, expectedMsg);	
		return alertMsg;
	}
	public void launchURL(){
		driver.get(configFileReader.getApplicationUrl());
	}
}