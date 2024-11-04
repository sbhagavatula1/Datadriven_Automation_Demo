package com.orangeHRM_SB.steps;

import com.orangeHRM_SB.actions.driverManager;
import com.orangeHRM_SB.pages.DashBoardPage;
import com.orangeHRM_SB.pages.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D_UserLoginCredentials_from_ScenarioAndExamples {
	LoginPage     loginPage      = new LoginPage(driverManager.getDriver());
	DashBoardPage dashBoard      = new DashBoardPage(driverManager.getDriver());
	
	@When("User enters valid username {string} and valid password {string} in the Scenario")
	public void user_enters_valid_username_and_valid_password_in_the_scenario(String UN_SC, String PW_SC) {
		System.out.println("****************************************************************************************");
		System.out.println("Userid from Scenario   = " + UN_SC);
		System.out.println("Password from Scenario = " + PW_SC);
		
		loginPage.Username(UN_SC);
		loginPage.Password(PW_SC);
	}
	@When("User enters valid username {string} and valid password {string} from Examples")
	public void user_enters_valid_username_and_valid_password_from_examples(String UN_EX, String PW_EX) {
		System.out.println("****************************************************************************************");
		System.out.println("");
		System.out.println("Userid from Examples   = " + UN_EX);
		System.out.println("Password from Examples = " + PW_EX);
		
		loginPage.Username(UN_EX);
		loginPage.Password(PW_EX);
	}
	@Then("User should be redirected to the Dashboard page with dashboard title {string}")
	public void user_should_be_redirected_to_the_dashboard_page_with_dashboard_title(String Expected_DashBoard_Title) {
		System.out.println("Expected DashBoard Title from Scenario/Examples  = " + Expected_DashBoard_Title);
		
		dashBoard = new DashBoardPage(driverManager.getDriver());
		dashBoard.waitToElementLoad(5);
		dashBoard.verifyTheDashBoardTitle(Expected_DashBoard_Title);
		
		System.out.println("****************************************************************************************");
	}	
}