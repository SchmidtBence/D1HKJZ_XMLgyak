package xpathd1hkjz1109;

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
import java.io.IOException;


public class xPathD1HKJZ {

    public static void main(String[] args) {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();

            Document doc = dBuilder.parse("studentD1HKJZ.xml");

            doc.getDocumentElement().normalize();

            //Xpath készítése
            XPath xPath= XPathFactory.newInstance().newXPath();

            //meg kell adni az elérési út kifejezést és a csomópont listát

            //1.feladat
            //String expression="class";
            //1.feladat
            //String expression="class/student";
            //2.feladat
            //String expression="class/student[1]";
            //3.feladat
            //String expression="class/student[1]";
            //4.feladat
            //String expression="class/student[position()=2]";
            //5.feladat
            //String expression="class/student[last()]";
            //6.feladat
            //String expression="class/student[last()-1]";
            //7.feladat
            //String expression="class/student[position()<3]";
            //8.feladat
            //String expression="class/student";
            //9.feladat
            //String expression="class/student[@id]";
            //10.feladat
            //String expression="class";
            //11.feladat
            //String expression="class/student[kor>20]";
            //12.feladat
            String expression="class/student/keresztnév | vezetéknév";

            //Készítsünk egy listát, majd a Path kifejezést meg kell írni és ki kell értékelni.
            NodeList nodeList=(NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            //A for ciklus segítségével a NodeList csomópontjait végig kell iterrálni.
            for (int i=0;i<nodeList.getLength();i++){
                Node node=nodeList.item(i);
                System.out.println ("\naktuális elem: " + node.getNodeName());


                //meg kell vizsgálni a cssomópontot, az subelement tesztelése megtörtént
                if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")){
                    Element element =(Element) node;

                    //az id attributomt ad vissza
                    System.out.println ("Hallgató ID: "
                            + element.getAttribute("id"));

                    System.out.println ("Keresztnév: "
                            + element.getElementsByTagName("keresztnév").item(0).getTextContent());

                    System.out.println ("Keresztnév: "
                            + element.getElementsByTagName("vezetéknév").item(0).getTextContent());

                    System.out.println ("Becenév: "
                            + element.getElementsByTagName("becenév").item(0).getTextContent());

                    System.out.println ("Kor: "
                            + element.getElementsByTagName("kor").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException | XPathExpressionException | IOException | SAXException e){
            e.printStackTrace();
        }

    }


}
