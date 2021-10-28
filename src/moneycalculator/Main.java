package moneycalculator;
import Model.*;
import View.Persistence.DataBase;
import View.Persistence.FillList;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static AllCurrencies list = new AllCurrencies();
   
    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
        DataBase.connect();
        init();
        for (Currency currency : list) {
            for (Currency currency1 : list) {
                
                System.out.println(DataBase.getData(currency.getCode().toLowerCase(),
                        currency1.getCode().toLowerCase()));
            }
            
        }
        
        DataBase.disconnect();
    }
    
    public static void init() throws IOException{
        
        list = FillList.fill();
        
        
    }
}
