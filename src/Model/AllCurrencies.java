package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllCurrencies extends HashSet<Currency> {
    private static AllCurrencies list;
    private AllCurrencies() {
        super();
    }
    
    public static AllCurrencies init(){
        if(list == null){
            list=new AllCurrencies();
        }
        return list;
    }
    public static void setCurrency(Currency divisa) {
        if(!list.contains(divisa))
        list.add(divisa);
    }
    
    public static List<Currency> getList(){
        List<Currency> arr = new ArrayList<>();
        for (Currency currency : list) {
            arr.add(currency);
        }
        
        return arr ;
    }

    @Override
    public String toString() {
        String str = "";
        for (Currency currency : list) {
            str = str + currency + "\n";
            
        }
        return str;
    }
    


   
    
    
}
