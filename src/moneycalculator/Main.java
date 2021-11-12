package moneycalculator;
import Model.*;
import View.Persistence.FillList;
import java.io.IOException;


public class Main {
    public static AllCurrencies list = new AllCurrencies();
   
    public static void main(String[] args) throws IOException{
        init();
        
        for (Currency currency : list) {
            for (Currency currency1 : list) {
                System.out.println(new Change(currency,currency1).calculateA(10));
            }
            
        }
    }
    
    public static void init() throws IOException{
        
        list = FillList.fill();
        
        
    }
}
