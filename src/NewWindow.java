import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NewWindow {

    JFrame frame = new JFrame();
    JLabel label = new JLabel();

    JScrollPane scrPane;
    JPanel panel,contetPanel, container;
    private List<String[]> content;

    public NewWindow(){}

    NewWindow(List<String[]> _content){
        content = _content;

        panel = new JPanel();
        panel.setLayout(new GridLayout(0,1,0,10));
        get_panel();
         //scrPane = new JScrollPane(panel);


        scrPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        JButton btn = new JButton("Tjena");

        JLabel title = new JLabel();
        title.setText("Orginal");


        scrPane.add(title);

        frame.add(scrPane);


        scrPane.getViewport().revalidate();




        //frame.add(label);


        frame.setSize(500,350);


        frame.setVisible(true);
    }


    public void get_string(){
       // String listString = content.stream().map(Object::toString).collect(Collectors.joining(", "));
        //System.out.println(listString);

    }

    public void get_panel() {


        for (String[] str : content){
            String join = Arrays.toString(str);
           panel.add(new NewLabel(join).return_label());
        }

        content.clear();

    }
}
