import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class XMLFile {

    public XMLFile(String path){
        try
        {
            File file = new File(path);
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            System.out.println("Root element: "+ document.getDocumentElement().getNodeName());
            if (document.hasChildNodes())
            {
                printNodeList(document.getChildNodes());
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    private static void printNodeList(NodeList nodeList)
    {
        for (int count = 0; count < nodeList.getLength(); count++)
        {
            Node elemNode = nodeList.item(count);
            if (elemNode.getNodeType() == Node.ELEMENT_NODE)
            {
// get node name and value
                System.out.println("\nNode Name =" + elemNode.getNodeName()+ " [OPEN]");
                System.out.println("Node Content =" + elemNode.getTextContent());
                if (elemNode.hasAttributes())
                {
                    NamedNodeMap nodeMap = elemNode.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++)
                    {
                        Node node = nodeMap.item(i);
                        System.out.println("attr name : " + node.getNodeName());
                        System.out.println("attr value : " + node.getNodeValue());
                    }
                }
                if (elemNode.hasChildNodes())
                {
//recursive call if the node has child nodes
                    printNodeList(elemNode.getChildNodes());
                }
                System.out.println("Node Name =" + elemNode.getNodeName()+ " [CLOSE]");
            }
        }
    }


    public void readXMLByTagName(String path){
        try
        {
//creating a constructor of file class and parsing an XML file
            File file = new File(path);
//an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("row");
// nodeList is not iterable, so we are using for loop
            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);
                System.out.println("\nNode Name :" + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;


                    System.out.println("orderDate: "+ eElement.getElementsByTagName("OrderDate").item(0).getTextContent());
                    System.out.println("Region: "+ eElement.getElementsByTagName("Region").item(0).getTextContent());
                    System.out.println("Rep1 : "+ eElement.getElementsByTagName("Rep1").item(0).getTextContent());
                    System.out.println("Rep2: "+ eElement.getElementsByTagName("Rep2").item(0).getTextContent());
                    System.out.println("Item: "+ eElement.getElementsByTagName("Item").item(0).getTextContent());
                    System.out.println("Units: "+ eElement.getElementsByTagName("Units").item(0).getTextContent());
                    System.out.println("UnitCost: "+ eElement.getElementsByTagName("UnitCost").item(0).getTextContent());
                    System.out.println("Total: "+ eElement.getElementsByTagName("Total").item(0).getTextContent());

                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

}
