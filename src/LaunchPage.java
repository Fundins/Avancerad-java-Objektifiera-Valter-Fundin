import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Optional;

public class LaunchPage extends JFrame implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JButton sortButton;

    LaunchPage(){

        //Skapar frame, sedan lägger till panel från CreateWeek.
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(350,350);


        button = new JButton("Select File");
        button.addActionListener(this);

        sortButton = new JButton("Sort CVS File");
        sortButton.addActionListener(this);

        frame.add(button);
        frame.add(sortButton);

        frame.pack();
        frame.setVisible(true);


    }

    public JPanel get_panel(){
        //Här skapas en panel, där alla veckodagar kommer läggas till. Alla dagar är en en egen panel.
        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setSize(350,350);
        //For loop för alla dagar i veckan, från datumet(måndag-sön.)


        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() ==button){

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("./src/filer"));

            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Sheet-file","csv","xml","json"
            );

            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null); //


            if (response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                String fileName = file.toString();

                //Optional.ofNullable(fileName).filter(f->f.contains(".")).map(f-> f.substring(fileName.lastIndexOf(".") + 1));

                String end = fileName.substring(fileName.lastIndexOf("."));
                System.out.println(end);
                System.out.println(file);

                if(end.equals(".csv")){
                    CSVFile f = new CSVFile(fileName);
                    NewWindow newWindow = new NewWindow(f.get_CSV());

                }else if(end.equals(".json")){
                    JSONFile f = new JSONFile(fileName);
                    NewWindow newWindow = new NewWindow(f.get_JSON());
                }else if(end.equals(".xml")){
                   XMLFile x = new XMLFile(fileName);
                }
                else{
                    System.out.println("Err");
                }

            }
        }
    }
}
