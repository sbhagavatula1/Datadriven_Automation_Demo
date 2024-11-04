package PreTesting_CSV;

import java.io.*;  
import java.util.Scanner;  
public class testingCoonectToCSV1 {
	public static void main(String[] args) throws Exception {
		//parsing a CSV file into Scanner class constructor
		Scanner sc = new Scanner(new File("./Data/LoginCredentials_withHeader.csv"));
		sc.useDelimiter(",");             //sets the delimiter pattern
		while (sc.hasNext()) {            //returns a boolean value
			System.out.println(sc.next());  //find and returns the next complete token from this scanner  
		}
		sc.close();  //closes the scanner
	}
}  