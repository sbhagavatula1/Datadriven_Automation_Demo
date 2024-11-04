package PreTesting_ReadXML;

//Java Program to Write XML Using DOM Parser 
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.transform.Transformer; 
import javax.xml.transform.TransformerFactory; 
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult; 
import org.w3c.dom.Document; 
import org.w3c.dom.Element; 

public class XMLWriterExample { 
	public static void main(String[] args) throws Exception { 
		// Create a DocumentBuilder 
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder builder = factory.newDocumentBuilder(); 

		// Create a new Document 
		Document document = builder.newDocument(); 

		// Create root element 
		Element root = document.createElement("library"); 
		document.appendChild(root); 

		// Create book elements and add text content 
		Element book1 = document.createElement("Program1"); 
		book1.appendChild(document.createTextNode("Java Programming")); 
		Element book2 = document.createElement("Program2"); 
		book2.appendChild(document.createTextNode("Python Programming")); 
		Element book3 = document.createElement("Program3"); 
		book3.appendChild(document.createTextNode("JavaScript")); 
		Element book4 = document.createElement("Program4"); 
		book4.appendChild(document.createTextNode("C Programming")); 
		root.appendChild(book1); 
		root.appendChild(book2); 
		root.appendChild(book3); 
		root.appendChild(book4); 

		// Write to XML file 
		TransformerFactory transformerFactory = TransformerFactory.newInstance(); 
		Transformer transformer = transformerFactory.newTransformer(); 
		DOMSource source = new DOMSource(document); 

		// Specify your local file path 
		//StreamResult result = new StreamResult("C:/Users/Mahesh/Desktop/DSAˍPratice/output.xml");
		StreamResult result = new StreamResult(".\\Data\\output.xml"); 
		transformer.transform(source, result); 

		System.out.println("XML file created successfully!"); 
	} 
}