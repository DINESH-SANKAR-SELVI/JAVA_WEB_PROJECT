package BlueMoon;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.sql.*;


public class BlueMoonSyllabus {
  public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException, ClassNotFoundException, SQLException {
    File file = new File("C:\\Users\\WHITE_KITE\\eclipse-workspace\\BACKEND_WORK\\main\\webapp\\xml\\BlueMoon1.xml");
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(file);
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BlueMoon?characterEncoding=latin1","root","White@Kite_0110.");
    
    PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM bluemoon.notes");
    
    ResultSet rs = ps.executeQuery();
    
    int NoOfSub =0 , NOofTopic=0 ,NoOfBatch=0 , NoOfQuiz=0 ,NoOfOption=0 ;
    
        
    
    Element existingElement = (Element) document.getElementsByTagName("NOTES").item(0);

    for(int i=0;i<3;i++){
      Element newElement = document.createElement("SUBJECT");
      newElement.setAttribute("id", "JAVA1995230517");
      
      Element subjectName = document.createElement("SUBJECT_NAME");
      subjectName.setTextContent("JAVA");

      Element subjectAbout = document.createElement("SUBJECT_ABOUT");
      subjectAbout.setTextContent("JAVA IS USED TO DEVELOP LARGE SCALE OF APPLICATION AND USING VARY TYPES OF FIELD.");

      newElement.appendChild(subjectName);
      newElement.appendChild(subjectAbout);

      for(int j=0;j<3;j++){

        Element subjectTopic = document.createElement("TOPIC");
        subjectTopic.setAttribute("id", "JAVAOOPS230231");
        
        Element subjectTopicName = document.createElement("TOPIC_NAME");
        subjectTopicName.setTextContent("OOPS");

        subjectTopic.appendChild(subjectTopicName);
        for(int k=0;k<3;k++){

          Element subjectTopicBatch = document.createElement("BATCH");
          subjectTopicBatch.setAttribute("id", "JAVAOOPSSETFIR");
            
            for(int l=0;l<3;l++){

              Element subjectTopicBatchQuiz = document.createElement("QUIZ");
              subjectTopicBatchQuiz.setAttribute("id","JAOOSETFIRST01");
              subjectTopicBatchQuiz.setAttribute("POINTS","2");

              Element subjectTopicBatchQuizContent = document.createElement("QUIZCONTENT");
              subjectTopicBatchQuizContent.setTextContent("What Is Data ?");

              subjectTopicBatchQuiz.appendChild(subjectTopicBatchQuizContent);

              Element subjectTopicBatchQuizOption = document.createElement("OPTIONS");
              for(int m=0;m<4;m++){

                Element subjectTopicBatchopt = document.createElement("OPT");
                subjectTopicBatchopt.setAttribute("id","JAOOSETFIR01O1");
                subjectTopicBatchopt.setAttribute("ans","1");
                
                subjectTopicBatchopt.setTextContent("quiz");

                subjectTopicBatchQuizOption.appendChild(subjectTopicBatchopt);
              }

              subjectTopicBatchQuiz.appendChild(subjectTopicBatchQuizOption);

              subjectTopicBatch.appendChild(subjectTopicBatchQuiz);
            }          

          subjectTopic.appendChild(subjectTopicBatch);
        }

        newElement.appendChild(subjectTopic);
      }

      existingElement.appendChild(newElement);  
    }

    // Write the updated XML file to disk
    Writer writer = new FileWriter(file);
    javax.xml.transform.Transformer transformer = javax.xml.transform.TransformerFactory.newInstance().newTransformer();

    transformer.transform(new javax.xml.transform.dom.DOMSource(document), new javax.xml.transform.stream.StreamResult(writer));
    writer.close();

  }
}
