package PreTesting_OracleXE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class testingJDBCwithOracle21cXE_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("User ID: = ");
		String userId = sc.next();
		System.out.print("Pass Word: = ");
		String passWord = sc.next();
		System.out.print("Expected Message: = ");
		String alertMessage = sc.next();

		try {
			// Step1 - Load Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Step2 - Create connection
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			// DOES NOT WORK ???
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			// Step3 - Prepare SQL query
			PreparedStatement ps = con.prepareStatement("insert into OrangeHRM_SB values (?,?,?)");
			
			// Step4 - Print values
			ps.setString(1, userId);
			ps.setString(2, passWord);
			ps.setString(3, alertMessage);

			// Step5 - Fire SQL query
			int z = ps.executeUpdate();
			if (z > 0) {
				System.out.println("record saved successfully.");
			} else {
				System.out.println("record not saved.");
			}

			// Step5 - Close connection
			con.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}