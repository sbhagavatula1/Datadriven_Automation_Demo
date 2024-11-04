package PreTesting_JSON;

//Java program for write JSON to a file 

import java.io.FileNotFoundException; 
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap; 
import java.util.Map; 
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 

/*
 *	How to parse JSON in Java (Ref: https://www.geeksforgeeks.org/parse-json-java/)
 *
 *	JSON (JavaScript Object Notation) is a lightweight, text-based, language-independent
 *	data exchange format that is easy for humans and machines to read and write.
 *
 *	JSON can represent two structured types - objects and arrays:
 *		An object is an unordered collection of zero or more name/value pairs.
 *		An array is an ordered sequence of zero or more values.
 *	The values can be strings, numbers, booleans, null, and these two structured types.
 *
 *	Below is a simple example from Wikipedia that shows JSON representation of an object
 *	that describes a person. The object has:
 *		string values for first name and last name,
 *		a number value for age,
 *		an object value representing the person’s address, and
 *		an array value of phone number objects.
 *
 *	{
 *		"firstName": "John",
 *		"lastName": "Smith",
 *		"age": 25,
 *		"address": {
 *			"streetAddress": "21 2nd Street",
 *			"city": "New York",
 *			"state": "NY",
 *			"postalCode": 10021
 *		},
 *		"phoneNumbers": [
 *			{
 *				"type": "home",
 *				"number": "212 555-1234"
 *			},
 *			{
 *				"type": "fax",
 *				"number": "646 555-4567"
 *			}
 *		]
 *	}
 *
 *	JSON Processing in Java :
 *		The Java API for JSON Processing JSON.simple is a simple Java library
 *		that allow parse, generate, transform, and query JSON.
 *	Getting Started : You need to download the json-simple-1.1 jar and
 *	put it in your CLASSPATH before compiling and running the below example codes.
 *
 *	For importing jar in IDE like eclipse, refer here.
 *	If you are using maven you may use the following maven link:
 *		https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1
 *
 *	Json-Simple API :
 *		It provides object models for JSON object and array structures.
 *		These JSON structures are represented as object models using types - JSONObject and JSONArray:
 *		JSONObject - provides a Map view to access the unordered collection of zero or more name/value pairs from the model.
 *		JSONArray - provides a List view to access the ordered sequence of zero or more values from the model.
 */

public class JSONWriteExample2 { 
	public static void main(String[] args) throws FileNotFoundException {

		// creating JSONObject
		
		HashMap<String,Object> additionalDetails = new HashMap<String,Object>();
		JSONObject jo = new JSONObject(additionalDetails);

		additionalDetails.put("firstName", "John");
		additionalDetails.put("lastName", "Smith");
		additionalDetails.put("age", 25);

		//JSONObject jo = new JSONObject(additionalDetails);
		// putting data to JSONObject
		/*
			jo.put("firstName", "John");
			jo.put("lastName", "Smith");
			jo.put("age", 25);
		*/
		
		// for address data, first create LinkedHashMap
		Map m = new LinkedHashMap(4);
			m.put("streetAddress", "21 2nd Street");
			m.put("city", "New York");
			m.put("state", "NY");
			m.put("postalCode", 10021);
		// putting address to JSONObject
			jo.put("address", m);

		// for phone numbers, first create JSONArray
		JSONArray ja = new JSONArray();
			m = new LinkedHashMap(2);
				m.put("type", "home");
				m.put("number", "212 555-1234");
			// adding map to list
			ja.add(m);
			m = new LinkedHashMap(2);
				m.put("type", "fax");
				m.put("number", "212 555-1234");
			// adding map to list
			ja.add(m); 
		// putting phoneNumbers to JSONObject
		jo.put("phoneNumbers", ja);
		
		// writing JSON to file:"JSONExample.json" in cwd
		PrintWriter pw = new PrintWriter(".\\Data\\JSONExample2.json");
		pw.write(jo.toJSONString());
		
		pw.flush();
		pw.close();
	}
}