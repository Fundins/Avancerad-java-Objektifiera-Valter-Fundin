import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class NewWindow {

    JFrame frame = new JFrame();
    JLabel label = new JLabel();

    JScrollPane scrPane;
    JPanel panel;
    private List<String[]> content;

    private String[] firstRow;
    public NewWindow(){}

    //Två konstruktorer, en om man sorterar, och en för att bara visa datan.
    //Skillnaden är att om man sorterar så delas datan upp.
    //Där första raden med rubriker för allakolumner sparas seperat, så att inte den sorteras också.
    public NewWindow(List<String[]> _content, String[] _firstRow){

        //Sätter 'content' som ska visas.
        content = _content;
        firstRow = _firstRow;

        open_window();
    }

    public NewWindow(List<String[]> _content){
        //Sätter 'content' som ska visas.
        content = _content;

        open_window();
    }

    public void open_window(){
        //Panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(0,1,0,10));

        //Hämtar Panel som ska visas. Där alla info kommer ifrån
        get_panel();

        //Scrollable
        scrPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrPane);
        scrPane.getViewport().revalidate();
        frame.setSize(500,350);
        frame.setVisible(true);
    }


    public void get_panel() {

        //Hämtar varje panel som ska fyllas med texten.
        //Lägger först till första raden med kolumner.
        String firstRowString = Arrays.toString(firstRow);
        //Ny instans av klass
        panel.add(new CreateLabel(firstRowString).return_label());

        // Hämtar och förvandlar datan till en String, ArrayList(String[]) -> array(String[]) -> String
        //Loop varje array i ArrayList

        for (String[] str : content){
            // Tar hela String[] och gör om till en String.
            String join = Arrays.toString(str);
            // Lägger till den i en label med klassen CreateLabel.
           panel.add(new CreateLabel(join).return_label());
        }
        //Tömmer content.
        content.clear();

    }
}
