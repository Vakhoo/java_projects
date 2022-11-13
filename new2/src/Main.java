import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException {
//        Students s1 = new Students("vakho", "batsikadze", "5");
//        Students s2 = new Students("gaga", "nijaradze", "5");
//        Students s3 = new Students("nikoloz", "katsitadze", "5");
//
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(Students.getUniversity());

//        FIleUtil.createFile();
//        FIleUtil.writeIntoFile("vakho");
//        FIleUtil.readFile();
//        FIleUtil.deletaFile();

//        XmlUtil.createXML();

        System.out.println(XmlUtil.parseXML());

        for (Students students : XmlUtil.parseXML()){
            System.out.println(students);
        }


    }
}