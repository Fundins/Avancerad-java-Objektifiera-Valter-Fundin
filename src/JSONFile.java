
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JSONFile {

    private List<String[]> content;
    private  List<String[]> sortedContent;
    private String[] firstRow;


 public JSONFile(String file){

     //Fungerar som CSVFile fast använder sig av ett bibliotek, JSON SIMPLE.
     //Json parser.
     JSONParser parser = new JSONParser();
     String[] array = null;
     content = new ArrayList<>();
     String line ="";
     try{
            //Försöker att läsa filen, och lägga in den i en array.
         JSONArray a = (JSONArray) parser.parse(new FileReader(file));

         //Lägger varje array i ett objekt.
         for (Object o : a){
             //Gör om OBJECT till ett JSONOBJECT.
             JSONObject p = (JSONObject) o;

             //Gör om varje JSONOBJECT till en String.
             line =  (String) p.toJSONString();
             //Lägger till varje String i en array
             String[] test = line.split(",");
             //Lägger till varje array till content.
             content.add(test);

         }





     }catch (Exception e){
         e.printStackTrace();
     }
 }



    public List<String[]> get_JSON(){
        return content;
    }
    public List<String[]> get_SortedJSON(){
        return sortedContent;
    }
    public String[] get_firstRow(){
        return  firstRow;
    }

    public void print(){

        content.forEach(array -> System.out.println(Arrays.toString(array)));

    }
    public void sort(int index){
      //Samma sortering som CSVFILE, Läs den.

        sortedContent = new ArrayList<>();

        firstRow = content.get(0);
        content.remove(0);
        sortedContent = content;
        content.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] strings, String[] otherStrings) {
                return strings[index].compareTo(otherStrings[index]);
            }
        });
        /*for(String[] sa : content){
            System.out.println(Arrays.toString(sa));
        }*/



    }

}
