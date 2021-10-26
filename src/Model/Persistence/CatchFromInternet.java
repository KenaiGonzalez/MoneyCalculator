package Model.Persistence;

import Model.Currency;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.exit;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class CatchFromInternet {
    private static final String urls = "http://currencies.apps.grandtrunk.net/getlatest/";

    public CatchFromInternet() throws IOException {
        
    }
    public static double equivalence(Currency a,Currency b) throws IOException{
        String codeA = a.getCode().toLowerCase();
        String codeB = b.getCode().toLowerCase();
        try {
            URL url = new URL(urls + codeA + "/" + codeB);
            URLConnection cnet = url.openConnection();
            BufferedReader in = null;
            try{
                in = new BufferedReader(new InputStreamReader(cnet .getInputStream()));
            }catch(UnknownHostException ex){
                System.out.println("DATOS NO DISPONIBLES, CONTACTE CON ADMINISTRADOR DE LA APP");
                exit(1);
            }
            return Double.parseDouble(in.readLine());
        } catch (MalformedURLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            
            return 0;
        }
        
    }
}
