import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVFile {

    private ArrayList<String> rows;
    private List<String[]> content;

    CSVFile(String file){

        //String file = "src/filer/sample.csv";
        BufferedReader reader = null;
        String line = "";
        content = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {
                //String[] test = line.split(",");
                String[] test =  line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                content.add(test);

            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }


    public List<String[]> get_CSV(){
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
        /*
        for(String[] sa : content){
            System.out.println(Arrays.toString(sa));
        }*/



    }



}


