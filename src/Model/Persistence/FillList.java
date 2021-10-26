package Model.Persistence;

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
        File currencies = new File ("C:\\Users\\kenai\\Documents\\NetBeansProjects\\MoneyCalculator\\src\\Model\\Persistence\\currencies.txt");
        FileReader fr = new FileReader (currencies);
        BufferedReader br = new BufferedReader(fr);
        
        while(true){
            String read = br.readLine();
            if(read==null)break;
            String [] readSplit = read.split(",");
            list.setCurrency(new Currency(readSplit[0],readSplit[1],readSplit[2]));
        }
        
        return list;
    }
}
