package View.Persistence;

import Model.AllCurrencies;
import Model.Currency;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FillList {
    private static AllCurrencies list = AllCurrencies.init();
    public static AllCurrencies fill() throws FileNotFoundException, IOException{
        
        BufferedReader bf = new BufferedReader(new FileReader(new File("currencies.txt")));
        while(true){
            String read = bf.readLine();
            if(read == null) break;
            String[] currency = read.split(",");
            list.add(new Currency(currency[0],currency[1],currency[2]));
        }
     
        return list;
    }
}
