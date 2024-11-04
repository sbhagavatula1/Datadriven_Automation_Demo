package com.orangeHRM_SB.steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.orangeHRM_SB.actions.driverManager;
import com.orangeHRM_SB.pages.DashBoardPage;
import com.orangeHRM_SB.pages.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F_UserLoginCredentials_from_Config_File {
	LoginPage       loginPage      = new LoginPage(driverManager.getDriver());
	DashBoardPage   dashBoard      = new DashBoardPage(driverManager.getDriver());
	
	Properties      prop           = new Properties();
	String          configFilePath = System.getProperty("user.dir") + "/Configuration/orangeHRM_SB.properties";
	
	@When("User enters valid credentials in the steps via Config File")
	public void user_enters_valid_credentials_in_the_steps_via_config_file() throws IOException {		
		FileInputStream fis = new FileInputStream(configFilePath);
		prop.load(fis);
		
		System.out.println("****************************************************************************************");
		System.out.println("Userid from Config file   = " + prop.getProperty("uid_SB_cfg"));
		System.out.println("Password from Config file = " + prop.getProperty("pwd_SB_cfg"));
		
		loginPage.Username(prop.getProperty("uid_SB_cfg"));
		loginPage.Password(prop.getProperty("pwd_SB_cfg"));	
	}
	@Then("User should be redirected to the Dashboard page with dashboard title as shown in the Config file")
	public void user_should_be_redirected_to_the_dashboard_page_with_dashboard_title_as_shown_in_the_config_file() {
		String Expected_DashBoard_Title = prop.getProperty("dashBoardTitle_SB_cfg");
		
		dashBoard = new DashBoardPage(driverManager.getDriver());
		dashBoard.waitToElementLoad(5);
		dashBoard.verifyTheDashBoardTitle(Expected_DashBoard_Title);
		
		System.out.println("Expected DashBoard Title from Config file   = " + Expected_DashBoard_Title);
		System.out.println("****************************************************************************************");
	}
}