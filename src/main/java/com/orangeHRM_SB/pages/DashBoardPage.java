package com.orangeHRM_SB.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.orangeHRM_SB.actions.orangeHRM_SB_Actions;

public class DashBoardPage extends orangeHRM_SB_Actions {
	
	public WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	//public By dashBoradTitle                   = By.xpath("//div[@class='oxd-topbar-header']//div[1]");
	//public By topBarHeaderTitle_DashBoard_By   = By.xpath("//h6[text()='Dashboard']");
	public   By topBarHeaderTitle_By             = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
	public   By leftNavBarTab_DashBorad          = By.xpath("//span[text()='Dashboard']");
	
	public String verifyTheDashBoardTitle(String expected){
		String actualtitle = readText(topBarHeaderTitle_By, "TopBarHeader Title");
		Assert.assertEquals(actualtitle, expected);
		return actualtitle;
	}
}