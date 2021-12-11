package View.Persistence;

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
    private static final String urls = "https://raw.githubusercontent.com/fawazahmed0/currency-api/1/latest/currencies/";

    public static double equivalence(Currency a,Currency b) throws IOException{
        String codeA = a.getCode().toLowerCase();
        String codeB = b.getCode().toLowerCase();
        try {
            URL url = new URL(urls + codeA + "/" + codeB + ".min.json");
            URLConnection cnet = url.openConnection();
            BufferedReader in = null;
            
            in = new BufferedReader(new InputStreamReader(cnet.getInputStream()));
            String read = in.readLine();
            read = read.split(":")[2].replaceFirst("}", "");
            return Double.parseDouble(read);
        } catch (MalformedURLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }catch(UnknownHostException ex){
                System.out.println("DATOS NO DISPONIBLES, CONTACTE CON ADMINISTRADOR DE LA APP");
                exit(1);
        }
        return 0;
        
    }
}
