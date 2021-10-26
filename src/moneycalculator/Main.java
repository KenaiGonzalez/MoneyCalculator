/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator;
import Model.*;
import Model.Persistence.FillList;
import java.io.IOException;

/**
 *
 * @author kenai
 */
public class Main {
    public static AllCurrencies list = new AllCurrencies();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        init();
        Change oper = new Change(list.getList().get(0),list.getList().get(0));
        
        System.out.println(oper.calculateA(18));
        System.out.println(oper.calculateB(1));
        
        
    }
    
    public static void init() throws IOException{
        
        list = FillList.fill();
        
        
    }
}
