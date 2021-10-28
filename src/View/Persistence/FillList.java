package View.Persistence;

import Model.AllCurrencies;
import Model.Currency;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FillList {
    private static AllCurrencies list = AllCurrencies.init();
    public static AllCurrencies fill() throws FileNotFoundException, IOException{

        List<Currency> currencies = DataBase.getCurrencies();
        for (Currency currency : currencies) {
            if(currency == null)continue;
            list.add(currency);
        }
     
        return list;
    }
}
