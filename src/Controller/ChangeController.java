package Controller;

import Model.Currency;
import View.CurrencySelector;
import View.InputCurrencyPanel;
import View.OutputCurrencyPanel;
import View.Persistence.CatchFromInternet;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ChangeController {

    private static InputCurrencyPanel icp;
    private static OutputCurrencyPanel ocp;

    public ChangeController(InputCurrencyPanel icp, OutputCurrencyPanel ocp) {
        ChangeController.icp = icp;
        ChangeController.ocp = ocp;
    }
    
    public static void execute(){
        Currency inputCurrency = getCurrency(icp);
        if(inputCurrency == null)return;
        Double value = getValue(icp);
        if(value == null)return;
        Currency outputCurrency = getCurrency(ocp);
        if(outputCurrency == null)return;
        Double result = calculate(inputCurrency, outputCurrency, value);
        ocp.setValue(result,outputCurrency.getSimbol());
    }

    private static Currency getCurrency(CurrencySelector cs){
        Object currency = cs.getCurrency();
        if(currency != null){
            return (Currency) currency;
        } else {
            JOptionPane.showMessageDialog(new JFrame()
                    , "Selecciona una divisa de entrada"
                    , "Error"
                    , JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
    }
    private static Double getValue(InputCurrencyPanel cs) {
        String inputString = cs.getValue();
        Double inputValue;
        try{
            inputValue = Double.valueOf(inputString);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(new JFrame()
                    , "El valor debe ser numerico"
                    , "Error"
                    , JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return inputValue;
    }
    
    private static double calculate(Currency in,Currency out,double valueIn){
        try {
            return valueIn*CatchFromInternet.equivalence(in, out);
        } catch (IOException ex) {
            return 0;
        }
        
    }

}
