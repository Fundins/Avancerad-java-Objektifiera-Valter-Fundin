import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class LaunchPage extends JFrame implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JButton sortButton;

    LaunchPage(){

        //Skapar frames och  buttons med actionListener.
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



    @Override
    public void actionPerformed(ActionEvent e) {

        //Lyssnar efter 'button
        if(e.getSource() ==button){

            //JFileChooser för att hämta fil.
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("./src/filer")); //Startar i src-direktivet.

            //Tillåter bara filer med specifika ändelser.
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Sheet-file","csv","xml","json"
            );

            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null); //

            //Kollar om 'response' var korrekt = om användaren tryckte på 'lägg till' med rätt fill.
            if (response == JFileChooser.APPROVE_OPTION){
                //Sparar filen i FILE.
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                String fileName = file.toString();

                //Kollar fil-ändelse
                String end = fileName.substring(fileName.lastIndexOf("."));

                if(end.equals(".csv")){
                    //Ny instans, konstruktor behöver filnamnet.
                    CSVFile f = new CSVFile(fileName);
                    //Öppnar ett nytt fönster med informationen från CSVFile.
                    NewWindow newWindow = new NewWindow(f.get_CSV());

                }else if(end.equals(".json")){
                    //Samma sak som ovan.
                    JSONFile f = new JSONFile(fileName);
                    NewWindow newWindow = new NewWindow(f.get_JSON());
                }else if(end.equals(".xml")){
                   XMLFile x = new XMLFile(fileName);
                }
                else{
                }

            }
        }
        //'Lyssnar' efter 'sortButton'
        if(e.getSource() == sortButton){
            //Hämtar fil på samma sätt som 'button' ovanför.
            //Skillnaden att den använder en annan funktion som sorterar datan istället för att bara visa den -

            JFileChooser fChooser = new JFileChooser();
            fChooser.setCurrentDirectory(new File("./src/filer"));

            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "CSV-File","csv","json"
            );

            fChooser.setFileFilter(filter);

            int response = fChooser.showOpenDialog(null); //


            if (response == JFileChooser.APPROVE_OPTION){

                File file = new File(fChooser.getSelectedFile().getAbsolutePath());
                String fileName = file.toString();
                String end = fileName.substring(fileName.lastIndexOf("."));

                if(end.equals(".csv")){
                    CSVFile f = new CSVFile(fileName);
                    //Sorterar datan.
                    f.sort(2);
                    NewWindow newWindow = new NewWindow(f.get_CSV());

                }else if(end.equals(".json")){
                    JSONFile f = new JSONFile(fileName);
                    f.sort(2);
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
