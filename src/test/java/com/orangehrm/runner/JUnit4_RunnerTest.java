package com.orangehrm.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		// path of the feature files
		features = "src/test/resources/OrangeHRM_Login_SB_Features",
		
		// path of the step definition files
		glue= {"com.orangeHRM_SB.steps"},
		
		tags = ""
			+ "@C11_ValidCredentials_from_Steps"
		/*
			+ "@D11_ValidCredentials_from_Scenario or "
			+ "@D21_ValidCredentials_from_Examples or "
			+ "@E11_ValidCredentials_from_DataTable_withHeader or "
			+ "@E21_ValidCredentials_from_DataTable_withoutHeader or "
			+ "@F11_ValidCredentials_from_Config_File or "
			+ "@G11_ValidCredentials_from_Excel_File or "
			+ "@H11_ValidCredentials_from_CSV_File_withHeader or "
			+ "@H21_ValidCredentials_from_CSV_File_withoutHeader or "
			+ "@K11_ValidCredentials_from_MySQL_Database"
			+ "@L11_ValidCredentials_from_SQLSERVER_Database"
		*/
		/*
			+ "@M11_ValidCredentials_from_OracleXE_Database"
			+ "@I11_ValidCredentials_from_JSON_File"
			+ "@J11_ValidCredentials_from_XML_File"
		*/
		,
		
		//to generate different types of reporting
		plugin = {
			"pretty",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			"timeline:test-output-thread/",
			"html:test-outout",
			"json:json_output/cucumber.json",
			"junit:junit_xml/cucumber.xml",
			"rerun:target/failedRerun.txt"
		},
		
		//display the console output in a proper readable format
		monochrome = true,
		
		// to check the mapping is proper between feature file and step def file
		dryRun = false
		//dryRun = true
	)
	
public class JUnit4_RunnerTest {
	 
}