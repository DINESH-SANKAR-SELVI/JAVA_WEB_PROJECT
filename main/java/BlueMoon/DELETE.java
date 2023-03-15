package BlueMoon;

import java.io.*;

import javax.security.auth.Subject;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.w3c.dom.*;
import org.xml.sax.*;


public class DELETE{
    public void DeletePage() throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
       
      File file = new File("C:\\Users\\WHITE_KITE\\eclipse-workspace\\JAVA_WEB_PROJECT\\main\\webapp\\xml\\BlueMoonNotes.xml");
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(file);
        
      Element docn= document.getDocumentElement();  
      NodeList child = docn.getChildNodes();
      
      for (int i=0;i<child.getLength();i++) {
        System.out.println("\n");
        
        docn.removeChild(child.item(i));

        Writer writer = new FileWriter(file);
      javax.xml.transform.Transformer transformer = javax.xml.transform.TransformerFactory.newInstance().newTransformer();
  
      transformer.transform(new javax.xml.transform.dom.DOMSource(document), new javax.xml.transform.stream.StreamResult(writer));
      writer.close();
    }
  
    }
}
