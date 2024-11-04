package PreTesting_JSON;

//Java program to read JSON from a file 

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; 

public class readingCucumberJSONFile {
	
	public static void main(String[] args) throws Exception {
		
		// parsing file "JSONExample.json"
		Object obj  = new JSONParser().parse(new FileReader(".\\Data\\JSONExample.json"));
			// typecasting obj to JSONObject
			JSONObject jo  = (JSONObject) obj;
			
			System.out.println("*************************************************");
			// getting firstName and lastName
			String firstName = (String) jo.get("firstName");
			String lastName = (String) jo.get("lastName");
			System.out.println(firstName);
			System.out.println(lastName);
					
			// getting age
			long age = (long) jo.get("age");
			System.out.println(age);
					
			// getting address
			Map address = ((Map)jo.get("address"));
			// iterating address Map
			Iterator<Map.Entry> itr1 = address.entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();
					System.out.println(pair.getKey() + " : " + pair.getValue());
				}
				
			// getting phoneNumbers
			JSONArray ja = (JSONArray) jo.get("phoneNumbers");
			// iterating phoneNumbers
			Iterator itr2 = ja.iterator();
			while (itr2.hasNext()) {
				itr1 = ((Map) itr2.next()).entrySet().iterator();
				while (itr1.hasNext()) {
					Map.Entry pair = itr1.next();
					System.out.println(pair.getKey() + " : " + pair.getValue());
				}
			}
			System.out.println("*************************************************");

		// parsing file "LoginCredentials.json"
		Object obj1 = new JSONParser().parse(new FileReader(".\\Data\\LoginCredentials.json"));
			// typecasting obj to JSONObject
			JSONObject jo1  = (JSONObject) obj;
			String USERID1           = (String) jo1.get("USERID");
			String PASSWORD1         = (String) jo1.get("PASSOWRD");
			String EXPECTED_MESSAGE1 = (String) jo1.get("ExpectedMessage");
			System.out.println(USERID1);
			System.out.println(PASSWORD1);
			System.out.println(EXPECTED_MESSAGE1);
			System.out.println("*************************************************");

		// parsing file "LoginCredentials2.json"
		Object obj2 = new JSONParser().parse(new FileReader(".\\Data\\LoginCredentials2.json"));		
			// parsing file "JSONExample.json"
			// typecasting obj to JSONObject
			JSONObject jo2 = (JSONObject) obj2;
			String USERID2           = (String) jo2.get("USERID");
			String PASSWORD2         = (String) jo2.get("PASSOWRD");
			String EXPECTED_MESSAGE2 = (String) jo2.get("ExpectedMessage");
			System.out.println(USERID2);
			System.out.println(PASSWORD2);
			System.out.println(EXPECTED_MESSAGE2);
			System.out.println("*************************************************");

		/*
			// parsing file "LoginCredentials3.json"
			Object obj3 = new JSONParser().parse(new FileReader(".\\Data\\LoginCredentials3.json"));
				
				// typecasting obj to JSONObject
				JSONObject jo3 = (JSONObject) obj3;
				String USERID3           = (String) jo3.get("USERID");
				String PASSWORD3         = (String) jo3.get("PASSOWRD");
				String EXPECTED_MESSAGE3 = (String) jo3.get("ExpectedMessage");
				System.out.println(USERID3);
				System.out.println(PASSWORD3);
				System.out.println(EXPECTED_MESSAGE3);
				System.out.println("*************************************************");
		*/
	}
}