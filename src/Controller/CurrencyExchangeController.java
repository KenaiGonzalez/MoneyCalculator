package Controller;

import Model.Currency;
import View.InputCurrencyPanel;
import View.OutputCurrencyPanel;

public class CurrencyExchangeController {
    
    private static InputCurrencyPanel icp;
    private static OutputCurrencyPanel ocp;

    public CurrencyExchangeController(InputCurrencyPanel icp, OutputCurrencyPanel ocp) {
        CurrencyExchangeController.icp = icp;
        CurrencyExchangeController.ocp = ocp;
    }
    
    public static void execute(){
        Currency input = icp.getCurrency();
        icp.setSelectedCurrency(ocp.getCurrency());
        ocp.setSelectedCurrency(input);
        String inputValue = icp.getValue();
        String outputValue = ocp.getValue();
         if(inputValue.equals("")){
            inputValue = "0.0";
            outputValue = "0.0";
        }
        icp.setValue(outputValue.substring(0,outputValue.length()-2 ));
        ocp.setValue(Double.parseDouble(inputValue), input==null ?"":input.getSimbol());
    }
    
}
