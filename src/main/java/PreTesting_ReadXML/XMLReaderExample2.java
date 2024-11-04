package PreTesting_ReadXML;

//Java Program to Read XML Using DOM Parser 

import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import org.w3c.dom.Document; 
import org.w3c.dom.NodeList; 
import org.w3c.dom.Node; 
import java.io.File; 

public class XMLReaderExample2 { 
	public static void main(String[] args) throws Exception { 
		// Specify the file path as a File object
		//File xmlFile = new File(".\\Data\\output.xml");
		File xmlFile = new File(".\\Data\\LoginCredials.xml");

		// Create a DocumentBuilder 
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder builder = factory.newDocumentBuilder(); 

		// Parse the XML file 
		Document document = builder.parse(xmlFile); 

		// Access elements by tag name
		// NodeList nodeList = document.getElementsByTagName("library");
		NodeList nodeList = document.getElementsByTagName("LoginCredentials");
		for (int i = 0; i < nodeList.getLength(); i++) { 
			Node node = nodeList.item(i);
			System.out.println("Element Content: " + node.getTextContent());
		} 
	} 
} 
