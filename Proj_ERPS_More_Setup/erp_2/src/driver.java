package erp_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class driver {

	public static void main(String[] args) {
		//Schema
		boolean flag = true;
		try {
			validateWithSchema("order.xml","order.xsd");
		} catch (SAXException e) {
			flag = false;
		} catch (IOException e) {
			flag = false;
		}
		
		System.out.println("XML and Schema "+flag);
		
		
		// DTD
		flag = true;
		try {
			validateWithDTD("order.xml","order.dtd");
		} catch (FileNotFoundException e) {
			flag = false;
		} catch (ParserConfigurationException e) {
			flag = false;
		} catch (SAXException e) {
			flag = false;
		} catch (IOException e) {
			flag = false;
		}
		System.out.println("XML and DTD "+flag);
	}
	
	//Validates the XML with Schema
	public static void validateWithSchema(String xmlFile, String validationFile) throws SAXException, IOException{
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		((schemaFactory.newSchema(new File(validationFile))).newValidator()).validate(new StreamSource(new File(xmlFile)));
	}
	
	//Validates the XML with DTD
	public static void validateWithDTD(String xmlFile, String validationFile) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setValidating(true);
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		documentBuilder.setErrorHandler(new org.xml.sax.ErrorHandler(){
			public void error(SAXParseException exception) throws SAXException{
				throw exception;
			}
			public void fatalError(SAXParseException exception) throws SAXException{
				throw exception;
			}
			
			public void warning(SAXParseException exception) throws SAXException{
				throw exception;
			}
		});
		documentBuilder.parse(new FileInputStream(xmlFile));
		
	}


}
