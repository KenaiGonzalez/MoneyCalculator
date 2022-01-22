package Model;

import java.util.Objects;

public class Currency {
    private final String name;
    private final String code;
    private final String simbol;
    
    public Currency(String name, String code, String simbol) {
        this.name = name;
        this.code = code;
        this.simbol = simbol;
    }

    @Override
    public String toString() {
        return  name + ","+code ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Currency other = (Currency) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return Objects.equals(this.simbol, other.simbol);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.code);
        hash = 47 * hash + Objects.hashCode(this.simbol);
        return hash;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getSimbol() {
        return simbol;
    }

   
    
    
   
}
