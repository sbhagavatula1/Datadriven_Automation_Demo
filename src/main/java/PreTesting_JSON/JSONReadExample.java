 package PreTesting_JSON;

//Java program to read JSON from a file 

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; 

public class JSONReadExample  
{ 
 public static void main(String[] args) throws Exception {
	 
	 // parsing file "JSONExample.json"
	 //Object obj1 = new JSONParser().parse(new FileReader(".\\Data\\JSONExample.json"));
	 
	 //Object obj2 = new JSONParser().parse(new FileReader(".\\Data\\LoginCredentials2.json"));
	 Object obj2 = new JSONParser().parse(new FileReader(".\\Data\\LoginCredentials.json"));
	 
	 // typecasting obj to JSONObject
	 //JSONObject jo1 = (JSONObject) obj1;
	 JSONObject jo2 = (JSONObject) obj2;
	 
	 // getting firstName and lastName
	 //String firstName = (String) jo1.get("firstName");
	 //String lastName = (String) jo1.get("lastName");
	 //System.out.println(firstName);
	 //System.out.println(lastName);
	 
	 
	 String USERID           = (String) jo2.get("USERID");
	 String PASSWORD         = (String) jo2.get("PaSsOwRd");
	 String EXPECTED_MESSAGE = (String) jo2.get("ExpectedMessage");
	 System.out.println(USERID);
	 System.out.println(PASSWORD);
	 System.out.println(EXPECTED_MESSAGE);
	 
		 /*
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
	       
	     while (itr2.hasNext())  
	     { 
	         itr1 = ((Map) itr2.next()).entrySet().iterator(); 
	         while (itr1.hasNext()) { 
	             Map.Entry pair = itr1.next(); 
	             System.out.println(pair.getKey() + " : " + pair.getValue()); 
	         } 
	     }
	     */ 
 } 
}