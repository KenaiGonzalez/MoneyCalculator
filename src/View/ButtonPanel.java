package View;

import java.awt.event.ActionEvent;
import javax.swing.JButton;


public class ButtonPanel extends javax.swing.JPanel {
    private JButton exit;

    public ButtonPanel() {
        super();
        iniButton();
    }

    private void iniButton() {
        exit = new JButton("Exit");
        exit.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
        this.add(exit);
    }
    
}
