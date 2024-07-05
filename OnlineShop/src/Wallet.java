import java.util.*;

public class Wallet {
    private double balance;
    private String name;
public Wallet (String name , double balance){
    this.name=name;
    this.balance=balance;
}

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

}
