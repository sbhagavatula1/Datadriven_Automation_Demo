package PreTesting_MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class testingCoonectToMySQL {

	@Test
	public void testDB() throws ClassNotFoundException, SQLException {
		
		//	References:
		//		https://learn-automation.com/database-testing-using-selenium-webdriver/
		//		https://www.mysqltutorial.org/mysql-jdbc-tutorial/connecting-to-mysql-using-jdbc-driver/
		//		https://www.w3schools.com/mysql/mysql_insert.asp
		//		https://www.mysqltutorial.org/mysql-basics/
		//		https://www.mysqltutorial.org/mysql-basics/selecting-a-mysql-database-using-use-statement/
		//		https://dev.mysql.com/doc/connector-j/en/connector-j-connp-props-connection.html
		//		https://dev.mysql.com/doc/connector-j/en/connector-j-connp-props-connection.html
		//		
		
		//	Other references:
		//		https://www.youtube.com/watch?v=Sw3eqsKvfCM
		//		https://www.zyxware.com/articles/5495/how-can-we-import-and-export-csv-file-in-selenium-java
		//		https://www.softwaretestingmaterial.com/mssql-database-testing-using-selenium/#:
		//		https://www.youtube.com/watch?v=fqMAt9igdzw
		//		https://www.baeldung.com/java-connect-mysql
		//		https://www.unrepo.com/cucumber/writing-scenarios-and-scenario-outlines-cucumber-tutorial
		//		https://www.programiz.com/java-programming/enhanced-for-loop
		//		https://crunchify.com/how-to-iterate-through-java-list-4-way-to-iterate-through-loop/
		//		https://www.geeksforgeeks.org/iterate-through-list-in-java/
		//		https://www.tutorialspoint.com/how-to-iterate-over-a-java-list
		//		https://runestone.academy/ns/books/index
		//		https://www.w3schools.com/java/java_iterator.asp
		//		https://www.udemy.com/course/selenium-webdriver-with-cucumber-bdd-automation-framework/?utm_source=adwords&utm_medium=udemyads&utm_campaign=Search_DSA_Beta_Prof_la.EN_cc.US&campaigntype=Search&portfolio=USA&language=EN&product=Course&test=&audience=DSA&topic=&priority=Beta&utm_content=deal4584&utm_term=_._ag_162107351033_._ad_696074114832_._kw__._de_c_._dm__._pl__._ti_dsa-1677053911088_._li_9021701_._pd__._&matchtype=&gad_source=1&gclid=EAIaIQobChMIkMugx7CciAMV6zUIBR1_2Cd1EAMYASAAEgLnB_D_BwE&couponCode=NVD20PMUS
		//		https://www.lambdatest.com/support/docs/running-cucumber-scripts-with-testng-and-selenium/
		//		https://www.lambdatest.com/blog/testng-in-selenium/
		//		https://search.yahoo.com/search?fr=mcafee&type=E210US105G0&p=deepdive+into+testng+with+java+selenium+with+examples
		//		https://jsonapi.org/examples/
		//		https://gotapi.com/category/api-guide/
		//		
		
		// JDBS driver for mySQL
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("JDBC Driver Loaded");
		
		// JDBC Connection String
		// "jdbc:mysql://hostname:port/dbname","username","password"
		
		//	My machine's address as given by "https://whatismyipaddress.com/" is "209.94.152.69"
		//	But using it in place of "localhost" (see below) gave errors
		//Connection mySQLconnection =  DriverManager.getConnection("jdbc:mysql://209.94.152.69:3306/selenium","root","dbtstsel4");
		
		//	Hence using "localhost" for now
		Connection mySQLconnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","dbtstsel4");
		
		/*
			Need to figure out how to atore values in config properties file
			
			String db.database = "selenium";
			String db.url      = jdbc:mysql://localhost:3306/db.database;
			String db.username = root;
			//String db.password = dbtstsel4; // Recently changed to blank
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
		
		/*
		while (rs.next()) {
			String UN_mySQL = rs.getString("UserID");
			String PW_mySQL = rs.getString("PassWord");
			
			System.out.println("USERID   = " + UN_mySQL);
			System.out.println("PASSWORD = " + PW_mySQL);
		}
		*/
		
		rs.next();
		
		String UN_mySQL                   = rs.getString("userID");
		String PW_mySQL                   = rs.getString("passWORD");
		String expectedAlertMessage_mySQL = rs.getString("expectedAlertMessage");
		
		System.out.println("");
		System.out.println("USERID               = " + UN_mySQL);
		System.out.println("PASSWORD             = " + PW_mySQL);
		System.out.println("expectedAlertMessage = " + expectedAlertMessage_mySQL);
		System.out.println("");
	}
}