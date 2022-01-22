package moneycalculator;
import Model.*;
import View.MoneyCalculatorFrame;
import View.Persistence.FillList;
import java.io.IOException;


public class Main {
    public static AllCurrencies list = AllCurrencies.init();
   
    public static void main(String[] args) throws IOException{
        init();
        //MoneyCalculatorFrame mcf = new MoneyCalculatorFrame();
        
    }
    
    public static void init() throws IOException{
       
        list = FillList.fill();
         MoneyCalculatorFrame mcf = new MoneyCalculatorFrame();
        
    }
}
