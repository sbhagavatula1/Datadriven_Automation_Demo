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

public class K_UserLoginCredentials_from_MySQL_Database {

	LoginPage     loginPage     = new LoginPage(driverManager.getDriver());
	DashBoardPage dashBoard     = new DashBoardPage(driverManager.getDriver());
	
	@When("User enters valid credentials via MySQL database")
	public void user_enters_valid_credentials_via_my_sq_ldatabase() throws ClassNotFoundException, SQLException {
		//	References:
		//		https://learn-automation.com/database-testing-using-selenium-webdriver/
		//		https://www.mysqltutorial.org/mysql-jdbc-tutorial/connecting-to-mysql-using-jdbc-driver/
		
		//	Other references:
		//		https://www.youtube.com/watch?v=Sw3eqsKvfCM
		//		https://www.zyxware.com/articles/5495/how-can-we-import-and-export-csv-file-in-selenium-java
		//		https://www.softwaretestingmaterial.com/mssql-database-testing-using-selenium/#:
		//		https://www.youtube.com/watch?v=fqMAt9igdzw
		//		https://www.baeldung.com/java-connect-mysql
		
		// JDBS driver for mySQL
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("JDBC Driver Loaded");
		
		// JDBC Connection String
		// "jdbc:mysql://hostname:port/dbname","username","password"
		
		//	My machine's address as given by "https://whatismyipaddress.com/" is "209.94.152.69"
		//	But using it in place of "localhost" (see below) gave errors
		//Connection mySQLconnection =  DriverManager.getConnection("jdbc:mysql://209.94.152.69:3306/selenium","root","dbtstsel4");
		
		//	Hence using "localhost" for now
		//Connection mySQLconnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","dbtstsel4");
		Connection mySQLconnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","");
		
		/*
			Need to figure out how to atore values in config properties file
			
			String db.database = "selenium";
			String db.url      = jdbc:mysql://localhost:3306/db.database;
			String db.username = root;
			String db.password = dbtstsel4;
		*/
		
		System.out.println("Connected to mySQL DB");
		
		/*
         	mysql> create table OrangeHRM_SB(UserID varchar(20), PassWord varchar(20));
			Query OK, 0 rows affected (0.02 sec)

			mysql> show tables;
			+--------------------+
			| Tables_in_selenium |
			+--------------------+
			| orangehrm_sb       |
			+--------------------+
			1 row in set (0.00 sec)

			mysql> insert into orangeHRM_SB (UserID, PassWord) values('Admin', 'admin123');
			Query OK, 1 row affected (0.02 sec)
		 */
		
		Statement stmt = mySQLconnection.createStatement();
		
		/*
		 	The following cannot be executed since they do not produce result sets.
		 	Need to figure out how how to insert them into the code here.
		 	
			ResultSet rs1   = stmt.executeQuery("drop table OrangeHRM_SB");
			ResultSet rs2   = stmt.executeQuery("create table OrangeHRM_SB");
			ResultSet rs3   = stmt.executeQuery("insert into orangeHRM_SB (UserID, PassWord) values('Admin', 'admin123')");
		*/
		
		ResultSet rs   = stmt.executeQuery("select * from OrangeHRM_SB");
		
		rs.next();
		
		/*
		while (rs.next()) {
			String UN_mySQL = rs.getString("UserID");
			String PW_mySQL = rs.getString("PassWord");
			
			System.out.println("USERID   = " + UN_mySQL);
			System.out.println("PASSWORD = " + PW_mySQL);
		}
		*/
		
		System.out.println("****************************************************************************************");
		System.out.println("Userid from MySQL    = " + rs.getString("userid"));
		System.out.println("Password  from MySQL = " + rs.getString("password"));
		
		loginPage.Username(rs.getString("UserID"));
		loginPage.Password(rs.getString("PassWord"));
	}
	@Then("User should be redirected to the Dashboard page with dashboard title read from MySQL database")
	public void user_should_be_redirected_to_the_dashboard_page_with_dashboard_title_read_from_my_sql_database() throws ClassNotFoundException, SQLException {
		
		// JDBS driver for mySQL
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("JDBC Driver Loaded");
		
		// JDBC Connection String
		// "jdbc:mysql://hostname:port/dbname","username","password"
		
		//Connection mySQLconnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","dbtstsel4");
		Connection mySQLconnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","");
		
		System.out.println("Connected to mySQL DB");
		
		/*
         	mysql> create table OrangeHRM_SB(UserID varchar(20), PassWord varchar(20));
			Query OK, 0 rows affected (0.02 sec)

			mysql> show tables;
			+--------------------+
			| Tables_in_selenium |
			+--------------------+
			| orangehrm_sb       |
			+--------------------+
			1 row in set (0.00 sec)

			mysql> insert into orangeHRM_SB (UserID, PassWord) values('Admin', 'admin123');
			Query OK, 1 row affected (0.02 sec)
		 */
		
		Statement stmt = mySQLconnection.createStatement();
		ResultSet rs   = stmt.executeQuery("select * from OrangeHRM_SB");
		rs.next();
				
		System.out.println("Expected DashBoard Title from MySQL Database  = " + rs.getString("expectedAlertMessage"));
		
		String Expected_DashBoard_Title = rs.getString("expectedAlertMessage");
		
		dashBoard = new DashBoardPage(driverManager.getDriver());
		dashBoard.waitToElementLoad(5);
		dashBoard.verifyTheDashBoardTitle(Expected_DashBoard_Title);
		
		System.out.println("****************************************************************************************");	
	}
}