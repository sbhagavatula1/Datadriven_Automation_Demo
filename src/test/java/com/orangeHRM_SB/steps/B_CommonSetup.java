package com.orangeHRM_SB.steps;

import com.orangeHRM_SB.actions.driverManager;
import com.orangeHRM_SB.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class B_CommonSetup {
	LoginPage loginPage = new LoginPage(driverManager.getDriver());
	
	@Given("User is on the OrangeHRM login page")
	public void user_is_on_the_orange_hrm_login_page() {
		loginPage.launchURL();
		loginPage.waitForPageLoaded();
	}
	@When("click the Login button")
	public void click_on_the_login_button() {
		loginPage    = new LoginPage(driverManager.getDriver());
	    loginPage.clickOnLogin();
	    loginPage.waitToElementLoad(5);
	}
	@When("User enter invalid credentials")
	public void user_enter_invalid_credentials() {  
		loginPage.Username("Admin");
		loginPage.Password("admin1234");
	}
	@Then("User should see an error message")
	public void user_should_see_an_error_message() {
		loginPage = new LoginPage(driverManager.getDriver());
	    String alertMesage = "";
		if(alertMesage.equals("Invalid credentials")) {
			loginPage.verifyTheAlertMessage("Invalid credentials");
		}
		else if(alertMesage.equals("Required")){
			loginPage.verifyFieldAlertMessage("Required");
		}
	}
	@When("User click on the Login button without providing credentials")
	public void user_click_on_the_login_button_without_providing_credentials() {
		loginPage = new LoginPage(driverManager.getDriver());
		loginPage.clickOnLogin();
		loginPage.waitToElementLoad(5);
	}
	@When("User enter the password without providing a username")
	public void user_enter_the_password_without_providing_a_username() {
		loginPage = new LoginPage(driverManager.getDriver());
		loginPage.Password("admin1234");
	}
	@When("User enter the username without providing a password")
	public void user_enter_the_username_without_providing_a_password() {
		loginPage = new LoginPage(driverManager.getDriver());
		loginPage.Username("Admin");
	}
}