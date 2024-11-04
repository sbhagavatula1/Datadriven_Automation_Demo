package com.orangehrm.runner;

import static io.cucumber.junit.platform.engine.Constants.*;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")

@SelectClasspathResource   ("steps")
@ConfigurationParameter    (key = GLUE_PROPERTY_NAME,              value = "com.orangeHRM_SB.steps")
@ConfigurationParameter    (key = FEATURES_PROPERTY_NAME,          value = "src/test/resources/OrangeHRM_Login_SB_Features")

//@ConfigurationParameter    (key = FILTER_TAGS_PROPERTY_NAME,       value = "@C11_ValidCredentials_from_Steps")
@ConfigurationParameter    (key = FILTER_TAGS_PROPERTY_NAME,       value = "@D11_ValidCredentials_from_Scenario")
//@ConfigurationParameter    (key = FILTER_TAGS_PROPERTY_NAME,       value = "@D21_ValidCredentials_from_Examples")
//@ConfigurationParameter    (key = FILTER_TAGS_PROPERTY_NAME,       value = "@E11_ValidCredentials_from_DataTable_withHeader")
//@ConfigurationParameter    (key = FILTER_TAGS_PROPERTY_NAME,       value = "@E21_ValidCredentials_from_DataTable_withoutHeader")
//@ConfigurationParameter    (key = FILTER_TAGS_PROPERTY_NAME,       value = "@F11_ValidCredentials_from_Config_File")
//@ConfigurationParameter    (key = FILTER_TAGS_PROPERTY_NAME,       value = "@G11_ValidCredentials_from_Excel_File")
//@ConfigurationParameter    (key = FILTER_TAGS_PROPERTY_NAME,       value = "@H11_ValidCredentials_from_CSV_File_withHeader")
//@ConfigurationParameter    (key = FILTER_TAGS_PROPERTY_NAME,       value = "@H21_ValidCredentials_from_CSV_File_withoutHeader")
//@ConfigurationParameter    (key = FILTER_TAGS_PROPERTY_NAME,       value = "@K11_ValidCredentials_from_MySQL_Database")
//@ConfigurationParameter    (key = FILTER_TAGS_PROPERTY_NAME,       value = "@L11_ValidCredentials_from_SQLSERVER_Database")
//@ConfigurationParameter    (key = FILTER_TAGS_PROPERTY_NAME,       value = "")

@ConfigurationParameter    (key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter    (key = PLUGIN_PROPERTY_NAME,            value = "pretty, html:target/cucumber-report/cucumber.html")

public class JUnit5_RunnerTest {
	 
}