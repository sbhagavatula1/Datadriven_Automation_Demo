package com.orangeHRM_SB.steps;

import java.util.List;
import java.util.Map;

import com.orangeHRM_SB.actions.driverManager;
import com.orangeHRM_SB.pages.DashBoardPage;
import com.orangeHRM_SB.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class E_UserLoginCredentials_from_DataTables {
	LoginPage     loginPage     = new LoginPage(driverManager.getDriver());
	DashBoardPage dashBoard     = new DashBoardPage(driverManager.getDriver());
	
	@When("User enters valid credentials from the datatable with header")
	public void user_enters_valid_credentials_from_the_datatable_with_header(DataTable dataTable) {
		
		System.out.println("****************************************************************************************");
		
		List<Map<String, String>> userList = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> e : userList) {
			System.out.println("Userid from Dataset with Header   = " + e.get("username_dt_wh"));
			System.out.println("Password from Dataset with Header = " + e.get("password_dt_wh"));
			
			loginPage.Username(e.get("username_dt_wh"));
			loginPage.Password(e.get("password_dt_wh"));
		}
	}
	@When("User enters valid credentials from the datatable without header")
	public void user_enters_valid_credentials_from_the_datatable_without_header(DataTable dataTable) {
		
		System.out.println("****************************************************************************************");
		
		List<List<String>> userList = dataTable.asLists(String.class);
	    for (List<String> e : userList) {
			System.out.println("Userid from Dataset without Header   = " + e.get(0));
			System.out.println("Password from Dataset without Header = " + e.get(1));
			
			loginPage.Username(e.get(0));
			loginPage.Password(e.get(1));
	    }
	}
	@Then("User should be redirected to the Dashboard page with dashboard title from Data Table with header")
	public void user_should_be_redirected_to_the_dashboard_page_with_dashboard_title_from_data_table_with_header(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> userList = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> e : userList) {
			System.out.println("Expected DashBoard Title from Dataset with header  = " + e.get("alertMessage_dt_wh"));
			
			String Expected_DashBoard_Title = e.get("alertMessage_dt_wh");
			
			dashBoard = new DashBoardPage(driverManager.getDriver());
			dashBoard.waitToElementLoad(5);
			dashBoard.verifyTheDashBoardTitle(Expected_DashBoard_Title);
			
			System.out.println("****************************************************************************************");
	    }
	}
	@Then("User should be redirected to the Dashboard page with dashboard title from Data Table without header")
	public void user_should_be_redirected_to_the_dashboard_page_with_dashboard_title_from_data_table_without_header(io.cucumber.datatable.DataTable dataTable) {	
		
		List<List<String>> userList = dataTable.asLists(String.class);
	    for (List<String> f : userList) {
			System.out.println("Expected DashBoard Title from Dataset without header   = " + f.get(0));

			String Expected_DashBoard_Title = f.get(0);
			
			dashBoard = new DashBoardPage(driverManager.getDriver());
			dashBoard.waitToElementLoad(5);
			dashBoard.verifyTheDashBoardTitle(Expected_DashBoard_Title);
			
			System.out.println("****************************************************************************************");
	    }
	}
}