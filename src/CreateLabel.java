import javax.swing.*;

public class CreateLabel extends NewWindow {

    JLabel label = new JLabel();
    String str;
   public CreateLabel(String _str){
        str=_str;
        label.setText(str);
    }

    public JLabel return_label(){
        return label;
    }

}
