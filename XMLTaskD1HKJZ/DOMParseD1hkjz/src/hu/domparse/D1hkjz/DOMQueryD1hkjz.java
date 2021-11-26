package hu.domparse.D1hkjz;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class DOMQueryD1hkjz {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // fájl beolvasása
            Document document = builder.parse(new File("XMLD1hkjz.xml"));
            document.getDocumentElement().normalize();
            //Xpath készítése
            XPath xPath= XPathFactory.newInstance().newXPath();

            //meg kell adni az elérési út kifejezést és a csomópont listát

            //Összes versenyző lekérdezése
            //String expression="root/Versenyzok/Versenyzo";
            //az utolso versenyzo lekérdezése
            String expression="root/Versenyzok/Versenyzo[last()]";

            //Készítsünk egy listát, majd a Path kifejezést meg kell írni és ki kell értékelni.
            NodeList nodeList=(NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

            //A for ciklus segítségével a NodeList csomópontjait végig kell iterrálni.
            for (int i=0;i<nodeList.getLength();i++){
                Node node=nodeList.item(i);
                System.out.println ("\naktuális elem: " + node.getNodeName());

                //meg kell vizsgálni a cssomópontot, az subelement tesztelése megtörtént
                if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("Versenyzo")){
                    Element element=(Element) node;
                    System.out.println("Versenyzo id: " + element.getAttribute("VAzon"));
                    System.out.println("Szektorazonositó id: " + element.getAttribute("Szektorazon"));
                    System.out.println("Díj id: " + element.getAttribute("Dazon"));
                    System.out.println("VersenyzőNév: "
                            + element.getElementsByTagName("VNev").item(0).getTextContent());

                }
            }
        } catch (ParserConfigurationException | XPathExpressionException | IOException | SAXException e){
            e.printStackTrace();
        }
    }
}
