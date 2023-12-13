import java.io.BufferedReader;
import java.io.FileReader;

public class JSONFile {
    public void getJsonFromFile(String filename){
        String jsonText ="";
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(filename));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                jsonText += line + "\n";
            }
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(jsonText);


    }




}
