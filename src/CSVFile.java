import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVFile {

    private ArrayList<String> rows;
    private List<String[]> content;
    public void readCSV(String file){

        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {

                String[] row = line.split(",");
                //String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                //use this if your values already contain commas
                for(String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
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
    public void readCSV2(String file){

        //String file = "src/filer/sample.csv";
        BufferedReader reader = null;
        String line = "";
        content = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {

                //rows = line.split(",");
                //String[] test = line.split(",");
                String[] test =  line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                content.add(test);
                //String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                //use this if your values already contain commas


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
        for(String[] sa : content){
            System.out.println(Arrays.toString(sa));
        }



    }



}


