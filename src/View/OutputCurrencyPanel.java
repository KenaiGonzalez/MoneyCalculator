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
import javax.swing.JTextField;

public class OutputCurrencyPanel extends javax.swing.JPanel implements CurrencySelector,OutputCurrency {
    private JComboBox cbOutputCurrency;
    private JLabel lOutputCurrency0;
    private JLabel lOutputCurrency1;
    private JLabel lOutputCurrency2;
    private final Dimension d = new Dimension(300,100);
    public OutputCurrencyPanel() {
        super();
        this.setLayout(new GridLayout(5,0,0,10)); 
        //this.setBackground(java.awt.Color.pink);
        this.initComponents();
        this.setPreferredSize(d);
        this.setMaximumSize(d);
        this.setMinimumSize(d);
        this.setVisible(true);
    }

    private void initComponents() {
        iniLabelCB();
        iniComboBox();
        iniLabel();
        iniLabelResult();
    }

    private void iniLabelCB() {
        lOutputCurrency0 = new JLabel("Elige la divisa de salida");
        this.add(lOutputCurrency0);
    }

    private void iniComboBox(){
        List<Currency> list = AllCurrencies.getList();
        cbOutputCurrency = new JComboBox(list.toArray());
        cbOutputCurrency.setPreferredSize(new Dimension(250,20));
        cbOutputCurrency.setMaximumSize(new Dimension(50,20));
        cbOutputCurrency.setMinimumSize(new Dimension(50,20));
        cbOutputCurrency.setEditable(true);
        cbOutputCurrency.setSelectedItem(null);
        JTextField cbEditor;
        cbEditor = (JTextField) cbOutputCurrency.getEditor().getEditorComponent();
        cbEditor.setText("");
        cbEditor.addKeyListener(addSuggestions()); 
        this.add(cbOutputCurrency);
    }
    
    private void iniLabel() {
        lOutputCurrency1 = new JLabel("Resultado:");
        this.add(lOutputCurrency1);
    }
    
    private void iniLabelResult() {
        lOutputCurrency2 = new JLabel("0.0");
        this.add(lOutputCurrency2);
    }

     

     @Override
    public Currency getCurrency() {
        if(cbOutputCurrency.getSelectedItem() instanceof String)return null;
        return (Currency) cbOutputCurrency.getSelectedItem();
    }

    @Override
    public void setValue(Double value,String symbol) {
        lOutputCurrency2.setText(symbol.equals("") ? value.toString():value.toString()+" "+symbol);
    }
    
    public String getValue(){
        return lOutputCurrency2.getText();
    }
    
    @Override
    public void setSelectedCurrency(Currency currency){
        cbOutputCurrency.setSelectedItem((Object)currency);
    }
    private KeyAdapter addSuggestions(){
        ArrayList<Object> lost = new ArrayList<>();
        JTextField cbEditor;
        cbEditor = (JTextField) cbOutputCurrency.getEditor().getEditorComponent();
        return new KeyAdapter(){
            @Override
            public void keyReleased(java.awt.event.KeyEvent arg0) {
                cbOutputCurrency.setPopupVisible(false);
                String text = cbEditor.getText();
                boolean comp = false;
                int count = 0;
                while(!lost.isEmpty()) {
                    for (int i = 0; i < cbOutputCurrency.getItemCount(); i++) {
                        
                        if(lost.get(count).equals(cbOutputCurrency.getItemAt(i))){
                            comp = true;
                            break;
                        }
                        
                    }
                    if(!comp){
                        cbOutputCurrency.addItem(lost.get(count));
                        lost.remove(lost.get(count));
                        count = 0;
                    }else count++;
                    comp = false;
                }
                
                for (int i = 0; i < cbOutputCurrency.getItemCount(); i++) {
                    if( (cbOutputCurrency.getItemAt(i).toString().length()<text.length())){
                        lost.add((Currency) cbOutputCurrency.getItemAt(i));
                            cbOutputCurrency.removeItemAt(i);
                            i = -1;
                            continue;
                    }
                    if (!cbOutputCurrency.getItemAt(i).toString().toLowerCase().substring(0, text.length())
                            .equals(text.toLowerCase())) {
                        lost.add((Currency) cbOutputCurrency.getItemAt(i));
                        cbOutputCurrency.removeItemAt(i);
                        i = -1;
                    }
                    
                    
                }
                cbEditor.setText(text);
                cbOutputCurrency.setPopupVisible(true);
                
            }
        };
     }
    
    

}
