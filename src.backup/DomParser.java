import java.io.File;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;



public class DomParser {
	public static void main(String[]args) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
		
		docFactory.setValidating(false);
		docFactory.setNamespaceAware(true);
		
		File file = new File("Student.xsd");

        // create schema
        String constant = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
        Schema schema = xsdFactory.newSchema(file);
        
        // set schema
        docFactory.setSchema(schema);
        
        System.out.println(docFactory.getSchema());
        DocumentBuilder builder=docFactory.newDocumentBuilder();
        Document document=builder.parse("XML文档1.xml");
        
        Element element=document.getDocumentElement();
        NodeList nodes=element.getChildNodes();
        for(int i=0;i<nodes.getLength();i++){
        	System.out.println(nodes.item(i).getNodeName());
        }
        
		
	}

}
