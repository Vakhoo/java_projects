import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlUtil {
    public static void createXML() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();

        Element sdutentsElements = document.createElement("students");
        document.appendChild(sdutentsElements);

        Element studentElement = document.createElement("student");
        sdutentsElements.appendChild((studentElement));

        Attr attr = document.createAttribute("groupNumber");
        attr.setValue("123");
        studentElement.setAttributeNode(attr);

        Element studentFirstName = document.createElement("FirstName");
        studentFirstName.appendChild(document.createTextNode("vakho"));
        studentElement.appendChild(studentFirstName);

        Element studentLastName = document.createElement("LastName");
        studentLastName.appendChild(document.createTextNode("batsikadze"));
        studentElement.appendChild(studentLastName);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource domSource = new DOMSource(document);

        StreamResult streamResult = new StreamResult(new File("vakho.xml"));
        transformer.transform(domSource, streamResult);
    }

    public static List<Students> parseXML() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse("vakho.xml");
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("student");
        List<Students> studentsList = new ArrayList<>();
        for (int i = 0; i<nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            Element element = (Element) node;
            String str = element.getAttribute("groupNumber");
            String firstName = element.getElementsByTagName(("FirstName")).item(0).getTextContent();
            String lastName = element.getElementsByTagName(("LastName")).item(0).getTextContent();

            studentsList.add(new Students(str, firstName, lastName));

        }
        return studentsList;

    }
}
