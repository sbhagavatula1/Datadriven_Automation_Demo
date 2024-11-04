package com.orangeHRM_SB.steps;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.orangeHRM_SB.actions.driverManager;
import com.orangeHRM_SB.pages.DashBoardPage;
import com.orangeHRM_SB.pages.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class H_UserLoginCredentials_from_CSV_File {
	
	// Reference: https://www.callicoder.com/java-read-write-csv-file-opencsv/
	
	LoginPage     loginPage                   = new LoginPage(driverManager.getDriver());
	DashBoardPage dashBoard                   = new DashBoardPage(driverManager.getDriver());

	//String      csvFilePath                 = ".\\Data\\LoginCredentials.csv";
	String        csvFilePath_withHeader      = ".\\Data\\LoginCredentials_withHeader.csv";
	String        csvFilePath_withoutHeader   = ".\\Data\\LoginCredentials_withoutHeader.csv";
	
	@When("User enters valid credentials via CSV file with header")
	public void user_enters_valid_credentials_via_csv_file_with_header() throws IOException, CsvException {
		
		System.out.println("****************************************************************************************");
		Reader reader = Files.newBufferedReader(Paths.get(csvFilePath_withHeader));
					
		//	Header Row included
		//	CSVReader csvReader = new CSVReader(reader);
					
		//	Skipping Header Row
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
		
		// Reading Records One by One in a String array
		/*
			System.out.println("Reading Records One by One in a String array");
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				System.out.println("UserID : " + nextRecord[0]);
				System.out.println("PassWord : " + nextRecord[1]);
				System.out.println("Message : " + nextRecord[2]);
				System.out.println("==========================");
			}
		*/
				
		//	Reading All Records at once into a List<String[]>
		//	Note:	Since this method loads the entire CSV contents into memory,
		//			it is not suitable for large CSV files.
		System.out.println("****************************************************************************************");
		//System.out.println("Reading All Records at once into a List<String[]>");
		List<String[]> records = csvReader.readAll();
		for (String[] record : records) {
			System.out.println("UserID : " + record[0]);
			System.out.println("PassWord : " + record[1]);
			
			loginPage.Username(record[0]);
			loginPage.Password(record[1]);	
		}
	}
	@Then("User should be redirected to the Dashboard page with dashboard title read from CSV file with header")
	public void user_should_be_redirected_to_the_dashboard_page_with_dashboard_title_read_from_csv_file_with_header() throws IOException, CsvException {

		Reader reader = Files.newBufferedReader(Paths.get(csvFilePath_withHeader));
					
		//	Header Row included
		//	CSVReader csvReader = new CSVReader(reader);
					
		//	Skipping Header Row
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
		// Reading Records One by One in a String array
		/*
			System.out.println("Reading Records One by One in a String array");
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				System.out.println("UserID : " + nextRecord[0]);
				System.out.println("PassWord : " + nextRecord[1]);
				System.out.println("Message : " + nextRecord[2]);
				System.out.println("==========================");
			}
		*/
			
		//	Reading All Records at once into a List<String[]>
		//	Note:	Since this method loads the entire CSV contents into memory,
		//			it is not suitable for large CSV files.		
		System.out.println("Reading All Records at once into a List<String[]>");
		List<String[]> records = csvReader.readAll();
		for (String[] record : records) {
			System.out.println("PassWord : " + record[2]);
			
			System.out.println("Expected DashBoard Title from CSV File  = " + record[2]);
			
			String Expected_DashBoard_Title = record[2];
			
			dashBoard = new DashBoardPage(driverManager.getDriver());
			dashBoard.waitToElementLoad(5);
			dashBoard.verifyTheDashBoardTitle(Expected_DashBoard_Title);
			
			System.out.println("****************************************************************************************");	
		}
	}
	@When("User enters valid credentials via CSV file without header")
	public void user_enters_valid_credentials_via_csv_file_without_header() throws IOException, CsvException {
		
		//CSVReader readcsv = new CSVReader(new FileReader(csvFilePath_withoutHeader));
		
		System.out.println("****************************************************************************************");
				
		Reader reader = Files.newBufferedReader(Paths.get(csvFilePath_withoutHeader));
					
		//	Top Row included (since there is no header in this data)
		CSVReader csvReader = new CSVReader(reader);
					
		//	Skipping Header Row
		//CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
		
		// Reading Records One by One in a String array
		
		/*
		System.out.println("Reading Records One by One in a String array");
		String[] nextRecord;
		while ((nextRecord = csvReader.readNext()) != null) {
			System.out.println("UserID : " + nextRecord[0]);
			System.out.println("PassWord : " + nextRecord[1]);
			System.out.println("Message : " + nextRecord[2]);
			System.out.println("==========================");
		}
		*/
				
		//	Reading All Records at once into a List<String[]>
		//	Note:	Since this method loads the entire CSV contents into memory,
		//			it is not suitable for large CSV files.
		
		System.out.println("****************************************************************************************");
		//System.out.println("Reading All Records at once into a List<String[]>");
		List<String[]> records = csvReader.readAll();
		for (String[] record : records) {
			System.out.println("UserID :   " + record[0]);
			System.out.println("PassWord : " + record[1]);
			
			loginPage.Username(record[0]);
			loginPage.Password(record[1]);	
		}
	}
	@Then("User should be redirected to the Dashboard page with dashboard title read from CSV file without header")
	public void user_should_be_redirected_to_the_dashboard_page_with_dashboard_title_read_from_csv_file_without_header() throws IOException, CsvException {
		Reader reader = Files.newBufferedReader(Paths.get(csvFilePath_withoutHeader));
					
		//	Top Row included (since there is no header in this data)
		CSVReader csvReader = new CSVReader(reader);
					
		//	Skipping Header Row
		//CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
		
		// Reading Records One by One in a String array
		
		/*
		System.out.println("Reading Records One by One in a String array");
		String[] nextRecord;
		while ((nextRecord = csvReader.readNext()) != null) {
			System.out.println("UserID : " + nextRecord[0]);
			System.out.println("PassWord : " + nextRecord[1]);
			System.out.println("Message : " + nextRecord[2]);
			System.out.println("==========================");
		}
		*/
				
		//	Reading All Records at once into a List<String[]>
		//	Note:	Since this method loads the entire CSV contents into memory,
		//			it is not suitable for large CSV files.
				
		System.out.println("Reading All Records at once into a List<String[]>");
		List<String[]> records = csvReader.readAll();
		for (String[] record : records) {
			System.out.println("PassWord : " + record[2]);
			
			System.out.println("Expected DashBoard Title from CSV File  = " + record[2]);
			
			String Expected_DashBoard_Title = record[2];
			
			dashBoard = new DashBoardPage(driverManager.getDriver());
			dashBoard.waitToElementLoad(5);
			dashBoard.verifyTheDashBoardTitle(Expected_DashBoard_Title);
			
			System.out.println("****************************************************************************************");	
		}
	}
}