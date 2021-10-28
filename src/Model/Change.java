package Model;

import View.Persistence.CatchFromInternet;
import java.io.IOException;

public class Change {
    private final Currency a;
    private final Currency b;
    private double valueA;
    private double valueB;

    public Change(Currency from, Currency to) {
        this.a = from;
        this.b = to;
    }
    
    public double calculateA(double bIn) throws IOException{
        valueB = bIn;
        valueA = valueB*CatchFromInternet.equivalence(a, b);
        return valueA;
    }
    public double calculateB(double aIn) throws IOException{
        valueA = aIn;
        valueB = valueA*CatchFromInternet.equivalence(b, a);
        return valueB;
    }
}
