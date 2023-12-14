
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JSONFile {

    private List<String> JSON;
    private List<String[]> content;


 public JSONFile(String file){
     JSONParser parser = new JSONParser();
     String[] array = null;
     content = new ArrayList<>();
     String line ="";
     try{
         //Object obj = parser.parse(new FileReader("src/filer/sample.json"));
         JSONArray a = (JSONArray) parser.parse(new FileReader(file));

         //System.out.println(a);
         for (Object o : a){
             JSONObject person = (JSONObject) o;

             line =  (String) person.toJSONString();
             String[] test = line.split(",");

             content.add(test);

         }





     }catch (Exception e){
         e.printStackTrace();
     }
 }



    public List<String[]> get_JSON(){
        return content;
    }

    public void print(){

        content.forEach(array -> System.out.println(Arrays.toString(array)));

    }
    public void sort(int index){
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
