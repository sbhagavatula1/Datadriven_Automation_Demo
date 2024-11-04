package com.orangeHRM_SB.steps;

import com.orangeHRM_SB.actions.driverManager;
import com.orangeHRM_SB.pages.DashBoardPage;
import com.orangeHRM_SB.pages.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class C_UserLoginCredentials_from_Steps {
	LoginPage		loginPage     = new LoginPage(driverManager.getDriver());
	DashBoardPage	dashBoard     = new DashBoardPage(driverManager.getDriver());
	
	@When("User enters valid userID and valid Password directly in the Steps")
	public void user_enters_user_id_and_password_directly_in_the_steps() {
		System.out.println("****************************************************************************************");
		
		loginPage.Username("Admin");
		System.out.println("Userid entered in steps   = " + "Admin");

		loginPage.Password("admin123");
		System.out.println("Password entered in steps = " + "admin123");
	}
	@Then("User should be redirected to the Dashboard page with title as shown in the expected alert message entered in the steps")
	public void user_should_be_redirected_to_the_dashboard_page_with_dashboard_title_as_shown_in_the_expected_alert_message_entered_in_the_steps() {

		//String ExpectedAlertMessage = "";
		String ExpectedAlertMessage = "Dashboard";
		System.out.println("Expected Alert message entered in steps = " + ExpectedAlertMessage);
		
		if(ExpectedAlertMessage.equals("Dashboard")) {
			dashBoard = new DashBoardPage(driverManager.getDriver());
			dashBoard.waitToElementLoad(5);
			dashBoard.verifyTheDashBoardTitle(ExpectedAlertMessage);
			System.out.println("****************************************************************************************");
		}
	}
}