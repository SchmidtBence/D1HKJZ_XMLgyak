package domD1HKJZ1026;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class DomReadD1HKJZ {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        File xmlFile = new File("usersD1HKJZ.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        System.out.println("Gyökér elem: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("user");

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) nNode;

                String uid = elem.getAttribute("id");
                String cur= elem.getNodeName();

                Node node1 = elem.getElementsByTagName("firstname").item(0);
                String firstname = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("lastname").item(0);
                String lastname = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("profession").item(0);
                String profession = node3.getTextContent();

                System.out.println("\tCurrent elem:" +cur);
                System.out.println("\tid: " + uid);
                System.out.println("\tfirstname: " + firstname);
                System.out.println("\tlastname: " + lastname);
                System.out.println("\tprofession: " + profession);
                System.out.println("");

            }
        }
    }
}