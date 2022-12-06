package interface_and_adapters.start_up_screens;

import javax.swing.*;

public class LabelHelper extends JPanel {

    public LabelHelper(JLabel label, JTextField textBox){
        this.add(label);
        this.add(textBox);
    }
}
