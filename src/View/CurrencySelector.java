package View;

import Model.Currency;
import javax.swing.JFrame;


public interface CurrencySelector {
    public Currency getCurrency();
    public void setSelectedCurrency(Currency currency);
}
