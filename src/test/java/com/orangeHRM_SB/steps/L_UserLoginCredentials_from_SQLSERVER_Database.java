package com.orangeHRM_SB.steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.orangeHRM_SB.actions.driverManager;
import com.orangeHRM_SB.pages.DashBoardPage;
import com.orangeHRM_SB.pages.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class L_UserLoginCredentials_from_SQLSERVER_Database {

	LoginPage     loginPage     = new LoginPage(driverManager.getDriver());
	DashBoardPage dashBoard     = new DashBoardPage(driverManager.getDriver());
	
	@When("User enters valid credentials via SQLSERVER database")
	public void user_enters_valid_credentials_via_my_sq_ldatabase() throws ClassNotFoundException, SQLException {
		
		//Load MS SQL JDBC Driver
		//Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//String connectionUrl  = "jdbc:sqlserver://localhost;port=1434;encrypt=true;database=selenium;trustServerCertificate=true;integratedSecurity=true";
		String connectionUrl    = "jdbc:sqlserver://localhost;port=1434;encrypt=true;database=selenium;trustServerCertificate=true";
		String username         = "sai";
		String password         = "dbtstsel4_12";
		
		//Load MS SQL JDBC Driver
		//Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//Creating connection to the database
		Connection con = DriverManager.getConnection(connectionUrl,username,password);
		
		//Creating statement object
		Statement st       = con.createStatement();
		String selectquery = "SELECT * FROM OrangeHRM_SB";
		
		//Executing the SQL Query and store the results in ResultSet
		ResultSet rs = st.executeQuery(selectquery);
		
		//While loop to iterate through all data and print results
		while (rs.next()) {
			System.out.println("Userid from SQLSERVER    = " + rs.getString("userid"));
			System.out.println("Password  from SQLSERVER = " + rs.getString("password"));
			
			loginPage.Username(rs.getString("userid"));
			loginPage.Password(rs.getString("password"));
		}
		
		//Closing DB Connection
		con.close();
	
	}
	@Then("User should be redirected to the Dashboard page with dashboard title read from SQLSERVER database")
	public void user_should_be_redirected_to_the_dashboard_page_with_dashboard_title_read_from_my_sql_database() throws ClassNotFoundException, SQLException {
		//Load MS SQL JDBC Driver
		//Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//String connectionUrl  = "jdbc:sqlserver://localhost;port=1434;encrypt=true;database=selenium;trustServerCertificate=true;integratedSecurity=true";
		String connectionUrl    = "jdbc:sqlserver://localhost;port=1434;encrypt=true;database=selenium;trustServerCertificate=true";
		String username         = "sai";
		String password         = "dbtstsel4_12";
		
		//Load MS SQL JDBC Driver
		//Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//Creating connection to the database
		Connection con = DriverManager.getConnection(connectionUrl,username,password);
		
		//Creating statement object
		Statement st       = con.createStatement();
		String selectquery = "SELECT * FROM OrangeHRM_SB";
		
		//Executing the SQL Query and store the results in ResultSet
		ResultSet rs = st.executeQuery(selectquery);
		
		//While loop to iterate through all data and print results
		while (rs.next()) {
			System.out.println("Expected_DashBoard_Title from SQLSERVER    = " + rs.getString("expected_message"));
	
			String Expected_DashBoard_Title = rs.getString("expected_message");
			
			dashBoard = new DashBoardPage(driverManager.getDriver());
			dashBoard.waitToElementLoad(5);
			dashBoard.verifyTheDashBoardTitle(Expected_DashBoard_Title);
			System.out.println("****************************************************************************************");	
		}
		
		//Closing DB Connection
		con.close();	
	}
}