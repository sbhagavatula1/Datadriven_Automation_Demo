package PreTesting_OracleXE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class testingJDBCwithOracle21cXE_2 {
	
	public static void main(String[] args) {

		try {
			// Step1 - Load Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Step2 - Create connection
			
			//	"1521:xe" sometimes results in:
			//		ORA-12505: Cannot connect to database.
			//		SID xe is not registered with the listener at host localhost port 1521.
			//		https://docs.oracle.com/error-help/db/ora-12505/
			
			//	Per stackoverflow, this could be due to specifying "1521:xe" instead of "1521/xe" or "1521/XE"
			//	https://stackoverflow.com/questions/18192521/ora-12505-tnslistener-does-not-currently-know-of-sid-given-in-connect-descript
			
			//	However, noticed that any of the 4 versions below worked without errors
			//	So the root cause could be something else, which needs further investigation

			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","admin");
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","system","admin");

			// Step3 - Prepare SQL query
			Statement st = con.createStatement();
			
			// Step4 - write the query
			String query = "select * from student";
			
			// Step5 - create JDBC ResultSet Obj
			ResultSet rs = st.executeQuery(query);
			
			System.out.println("****************************");
			// Step6 - Iterate through the ResultSet
			while (rs.next()) {
				/*
				System.out.println(
					rs.getInt(1)    + " " +
					rs.getString(2) + " " +
					rs.getString(3) + " " + 
					rs.getString(4) + " " + 
					rs.getInt(5)
				);
				*/
				System.out.println("Field-1 = " + rs.getInt(1));
				System.out.println("Field-2 = " + rs.getString(2));
				System.out.println("Field-3 = " + rs.getString(3));
				System.out.println("Field-4 = " + rs.getString(4));
				System.out.println("Field-5 = " + rs.getInt(5));
				System.out.println("****************************");
			}
			
			// Step7 - Close ResultSet
			rs.close();

			// Step8 - Close connection
			con.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}