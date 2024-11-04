package PreTesting_OracleXE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class testingJDBCwithOracle21cXE_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Roll: = ");
		int roll = sc.nextInt();
		System.out.print("Enter Name: = ");
		String name = sc.next();
		System.out.print("Enter Gender: = ");
		String gender = sc.next();
		System.out.print("Enter Address: = ");
		String address = sc.next();
		System.out.print("Enter Age: = ");
		int age = sc.nextInt();

		try {
			// Step1 - Load Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Step2 - Create connection
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			// DOES NOT WORK ???
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			// Step3 - Prepare SQL query
			PreparedStatement ps = con.prepareStatement("insert into student1 values (?,?,?,?,?)");
			
			// Step4 - Print values
			ps.setInt(1, roll);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setString(4, address);
			ps.setInt(5, age);

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