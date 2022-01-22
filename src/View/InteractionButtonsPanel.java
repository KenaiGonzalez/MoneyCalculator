package View;

import Controller.ChangeController;
import Controller.CurrencyExchangeController;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class InteractionButtonsPanel extends javax.swing.JPanel {
    private JButton intercambio;
    private JButton calcular;
    private final Dimension d = new Dimension(300,100);
    public InteractionButtonsPanel() {
        super();
        this.setLayout(new GridLayout(4,0,0,10)); 
        //this.setBackground(java.awt.Color.pink);
        this.initComponents();
        this.setPreferredSize(d);
        this.setMaximumSize(d);
        this.setMinimumSize(d);
        this.setVisible(true);
    }

    private void initComponents() {
        addGap();
        iniExchangeButton(); 
        iniCalculatedButton();
        addGap();
    }

    private void iniExchangeButton() {
        intercambio = new JButton("⇄");
        intercambio.addActionListener(((ActionEvent ae) -> {
            CurrencyExchangeController.execute();
        }));
        this.add(intercambio);
    }
    
    private void iniCalculatedButton(){
        calcular = new JButton("→");
        calcular.addActionListener((ActionEvent ae) -> {
            ChangeController.execute();
        });
        this.add(calcular);
    }
    
    private void addGap(){
        this.add(new JLabel());
    }

}
