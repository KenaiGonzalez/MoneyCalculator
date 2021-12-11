package View;

import Model.AllCurrencies;
import Model.Currency;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputCurrencyPanel extends JPanel implements CurrencySelector,InputCurrency {
    private Currency currency;
    private JComboBox cbInputCurrency;
    private JLabel lInputCurrency;
    private final Dimension d = new Dimension(300,100);
    private JTextField tfInputCurrency;
    private JLabel lInputCurrency2;

    public InputCurrencyPanel(){
        super();
        this.setLayout(new GridLayout(5,0,0,10)); 
        //this.setBackground(java.awt.Color.pink);
        this.initComponents();
        this.setPreferredSize(d); 
        this.setMaximumSize(d);
        this.setMinimumSize(d);
        this.setVisible(true);
        
    }

    @Override
    public Currency getCurrency() {
        if(cbInputCurrency.getSelectedItem() instanceof String)return null;
        return (Currency) cbInputCurrency.getSelectedItem();
    }

    @Override
    public String getValue() {
        return  tfInputCurrency.getText();
    }
    
    private void initComponents(){
        this.iniLabelCB();
        this.iniComboBox();
        this.iniLabelTF();
        this.iniTextField();
    }
    
    private void iniLabelCB(){
       this.lInputCurrency = new JLabel("Elige la divisa de entrada:");
       this.add(lInputCurrency);
    }
    
    private void iniComboBox(){
        List<Currency> list = AllCurrencies.getList();
        cbInputCurrency = new JComboBox(list.toArray());
        cbInputCurrency.setPreferredSize(new Dimension(250,20));
        cbInputCurrency.setMaximumSize(new Dimension(50,20));
        cbInputCurrency.setMinimumSize(new Dimension(50,20));
        cbInputCurrency.setEditable(true);
        JTextField cbEditor;
        cbEditor = (JTextField) cbInputCurrency.getEditor().getEditorComponent();
        cbEditor.setText("");
        cbEditor.addKeyListener(addSuggestions()); 
        this.add(cbInputCurrency);
    }
    
    private void iniTextField(){
        this.tfInputCurrency = new JTextField();
        tfInputCurrency.setText("0");
        this.add(tfInputCurrency);
    }
    
    private void iniLabelTF() {
        this.lInputCurrency2 = new JLabel("Introducir valor: ");
        this.add(lInputCurrency2);
        
    }
    
    private KeyAdapter addSuggestions(){
        ArrayList<Object> lost = new ArrayList<>();
        JTextField cbEditor;
        cbEditor = (JTextField) cbInputCurrency.getEditor().getEditorComponent();
        return new KeyAdapter(){
            @Override
            public void keyReleased(java.awt.event.KeyEvent arg0) {
                cbInputCurrency.setPopupVisible(false);
                String text = cbEditor.getText();
                boolean comp = false;
                int count = 0;
                while(!lost.isEmpty()) {
                    for (int i = 0; i < cbInputCurrency.getItemCount(); i++) {
                        
                        if(lost.get(count).equals(cbInputCurrency.getItemAt(i))){
                            comp = true;
                            break;
                        }
                        
                    }
                    if(!comp){
                        cbInputCurrency.addItem(lost.get(count));
                        lost.remove(lost.get(count));
                        count = 0;
                    }else count++;
                    comp = false;
                }
                
                for (int i = 0; i < cbInputCurrency.getItemCount(); i++) {
                    if( (cbInputCurrency.getItemAt(i).toString().length()<text.length())){
                        lost.add((Currency) cbInputCurrency.getItemAt(i));
                            cbInputCurrency.removeItemAt(i);
                            i = -1;
                            continue;
                    }
                    if (!cbInputCurrency.getItemAt(i).toString().toLowerCase().substring(0, text.length())
                            .equals(text.toLowerCase())) {
                        lost.add((Currency) cbInputCurrency.getItemAt(i));
                        cbInputCurrency.removeItemAt(i);
                        i = -1;
                    }
                    
                    
                }
                cbEditor.setText(text);
                cbInputCurrency.setPopupVisible(true);
                
            }
        };
    }



   

}
