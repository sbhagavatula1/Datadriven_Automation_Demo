package com.orangeHRM_SB.steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.orangeHRM_SB.actions.driverManager;
import com.orangeHRM_SB.pages.DashBoardPage;
import com.orangeHRM_SB.pages.LoginPage;
import com.orangeHRM_SB.utilities.ExcelReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class G_UserLoginCredentials_from_Excel_File {

	LoginPage     loginPage     = new LoginPage(driverManager.getDriver());
	DashBoardPage dashBoard     = new DashBoardPage(driverManager.getDriver());
	
	ExcelReader   excelReader   = new ExcelReader();
	String        excelFilePath = ".\\Data\\LoginCredentials.xlsx";
	
	@When("user enters valid user credentials read from excel sheet name {string} and row number {int}")
	public void user_enters_valid_user_credentials_read_from_excel_sheet_name_and_row_number(String excelSheetName, Integer excelRowNumber) throws InvalidFormatException, IOException {
		//ExcelReader excelReader = new ExcelReader();
		
		// If the 2nd argument in "getData" function call is numeric like "0" (zero), then
		// the sheet is referred to by sheet number or sheet name 
		List<Map<String,String>> loginTestData = excelReader.getData(excelFilePath, 0);
		
		// If the 2nd argument in "getData" function call is alpha like "sheetName", then
		// the sheet is referred to only by sheet name, not sheet number
		//List<Map<String,String>> loginTestData = excelReader.getData(excelFilePath, sheetName);
		
		//	The excel file has the following columns:
		//		"Username"
		//		"Password"
		//		"ExpectedMsg"
		
		System.out.println("****************************************************************************************");
		System.out.println("Userid from Excel file           = " + loginTestData.get(excelRowNumber).get("Username"));
		System.out.println("Password from Excel file         = " + loginTestData.get(excelRowNumber).get("Password"));
		System.out.println("");
		
		loginPage.Username(loginTestData.get(excelRowNumber).get("Username"));
		loginPage.Password(loginTestData.get(excelRowNumber).get("Password"));
	}
	@Then("User should be redirected to the dashboard page with dashboard title read from excel sheet name {string} and row number {int}")
	public void user_should_be_redirected_to_the_dashboard_page_with_dashboard_title_read_from_excel_sheet_name_and_row_number(String excelSheetName, Integer excelRowNumber) throws InvalidFormatException, IOException {
		// If the 2nd argument in "getData" function call is numeric like "0" (zero), then
		// the sheet is referred to by sheet number or sheet name 
		List<Map<String,String>> loginTestData = excelReader.getData(excelFilePath, 0);
		
		// If the 2nd argument in "getData" function call is alpha like "sheetName", then
		// the sheet is referred to only by sheet name, not sheet number
		//List<Map<String,String>> loginTestData = excelReader.getData(excelFilePath, sheetName);
		
		//	The excel file has the following columns:
		//		"Username"
		//		"Password"
		//		"ExpectedMsg"

		String Expected_DashBoard_Title = loginTestData.get(excelRowNumber).get("ExpectedMsg");
		
		System.out.println("Expected Message from Excel file = " + Expected_DashBoard_Title);
		
		dashBoard = new DashBoardPage(driverManager.getDriver());
		dashBoard.waitToElementLoad(5);
		dashBoard.verifyTheDashBoardTitle(Expected_DashBoard_Title);
		
		System.out.println("****************************************************************************************");
	}
}