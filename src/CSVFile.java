import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVFile {

    private ArrayList<String> rows;
    private List<String[]> content;

    CSVFile(String file){

        //BufferedReader som ska läsa in filen
        BufferedReader reader = null;
        String line = "";
        content = new ArrayList<>();
        try {
            //Försöker att läsa in filen m filerReader
            reader = new BufferedReader(new FileReader(file));
            //Loop som kör till den läst in allt.
            while((line = reader.readLine()) != null) {

                //Splittar varje line i filen med ',', läggs in i en array.
                String[] test =  line.split(",");
                //Varje array läggs in i en ArrayList.
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
        //sorterar filen med en egen comparator.
        // Den jämför två strings, i varje Array.
        //Som sorteras med .sort.
        //Index är vilken 'row' i filen.


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


