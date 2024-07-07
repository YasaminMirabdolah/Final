import java.util.*;

public class Seller extends Users{
    public Role role=Role.Seller;
    private ArrayList<product> productsToSell= new ArrayList<>();
    private double wallet= 0;
    public Seller(Role role , String companyname , String password){
        super(role , companyname , password);


    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
    public void addmoney(double money){
        wallet=wallet+money;
    }
}
