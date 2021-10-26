package Model;

public class Money {
    private double amountMoney;
    private Currency divisa;

    public Money(double amountMoney, Currency divisa) {
        this.amountMoney = amountMoney;
        this.divisa = divisa;
    }

    public double getAmountMoney() {
        return amountMoney;
    }

    public Currency getDivisa() {
        return divisa;
    }

    @Override
    public String toString() {
        return amountMoney + " " +divisa ;
    }
    
    
}
