import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Sorter {

    void sprtATextFile(String fileName,String toFileName) throws IOException{
        Path path = Paths.get(fileName);
        Charset charset = Charset.forName("UTF-8");

        List<String> lines = Files.readAllLines(path,charset);
        Collections.sort(lines);

        Path toPath = Paths.get(toFileName);
        Files.write(toPath,lines,charset);
    }
}
