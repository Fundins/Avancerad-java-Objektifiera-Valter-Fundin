import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {


       // JsonParser p = new JsonParser();
        //getcsvFile("src/filer/sample.json");
        //ReadXML XML = new ReadXML();
        //XML.readFileXML("src/filer/sample.xml");
        XMLFile XML = new XMLFile();
        //XML.readXMLNodes("src/filer/sample.xml");
        XML.readXMLByTagName("src/filer/sample.xml");
    }
}