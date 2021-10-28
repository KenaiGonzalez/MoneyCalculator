package View.Persistence;

import Model.Currency;
import com.sun.istack.internal.Nullable;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    private static Connection conn;
    public static void connect(){
        String url = "jdbc:sqlite:db_moneycalculator.db";
       
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Database connection stable");
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        } 
    }
    public static List<Currency> getCurrencies(){
        String sql = "SELECT * FROM currencies";
        List<Currency> list = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while(rs.next()){
                    
                    list.add(new Currency(rs.getString("Name"),rs.getString("Code"),rs.getString("Symbol")));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            exit(1);
        }
        return list;
    }
    public static double getData(String table, String fila){
        
        String sql = "SELECT * FROM " + table + " WHERE divisa = "+ "\""+fila+"\"";
        try {
            System.out.println(table + "-->" + fila);
            Statement stmt = conn.createStatement();
            Double result;
            try (ResultSet rs = stmt.executeQuery(sql)) {
                result = rs.getDouble("valor");
            }
            return result;
        } catch (SQLException ex) {
            
        }
        return 0;
    }
    
    public static void disconnect() throws SQLException{
        conn.close();
        System.out.println("Database connection closed");
    }
}
