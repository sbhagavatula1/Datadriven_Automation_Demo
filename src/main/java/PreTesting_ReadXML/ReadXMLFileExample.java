package PreTesting_ReadXML;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFileExample
{

	public static void main(String[] args){
		try {
			
			//File file = new File("C:.\\Data\\SampleXML.xml");
			File file = new File("C:.\\Data\\LoginCredials.xml");
			
			//Create a new object of DocumentBuilderFactory
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			//Create an object DocumentBuilder to parse the XML file data
			DocumentBuilder db  = dbf.newDocumentBuilder();
			Document        doc = db.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println("Root element name is: " + doc.getDocumentElement().getNodeName());
			
			//Creating a list of nodes present in the XML file
			/*
			NodeList nodeList = doc.getElementsByTagName("mobile");
			
			for (int i = 0; i< nodeList.getLength(); i++){
				   Node node = nodeList.item(i);  
				   System.out.println("\n"+"("+i+")" +" Child Node Name :" + node.getNodeName());
				   if (node.getNodeType() == Node.ELEMENT_NODE){
					      Element element = (Element) node;
					      System.out.println("Mobile id: "+ element.getElementsByTagName("id").item(0).getTextContent());
					      System.out.println("Brand Name: "+ element.getElementsByTagName("brand").item(0).getTextContent());
					      System.out.println("Model Name: "+ element.getElementsByTagName("model").item(0).getTextContent());
					      System.out.println("Mobile Price: "+ element.getElementsByTagName("price").item(0).getTextContent());
				   }  
			}
			*/
			NodeList nodeList = doc.getElementsByTagName("UserCredential");
			for (int i = 0; i< nodeList.getLength(); i++){
				if (i == 2) {
					Node node = nodeList.item(i);
					System.out.println("\n"+"("+i+")" +" Child Node Name :" + node.getNodeName());
					if (node.getNodeType() == Node.ELEMENT_NODE){
						Element element = (Element) node;
						System.out.println("User Number: "+ element.getElementsByTagName("id").item(0).getTextContent());
						System.out.println("User ID: "+ element.getElementsByTagName("userid").item(0).getTextContent());
						System.out.println("Password: "+ element.getElementsByTagName("password").item(0).getTextContent());
						System.out.println("Expected Alert Message: "+ element.getElementsByTagName("alertmessage").item(0).getTextContent());
					}
				}
			}
		}
		catch (Exception e){  
			e.printStackTrace();  
		}
	}
}