import java.util.*;

public class Seller extends Users{
    public Role role=Role.Seller;
    private ArrayList<product> productsToSell= new ArrayList<>();
    private Wallet wallet= new Wallet();
    public Seller(Role role , String companyname , String password){
        super(role , companyname , password);


    }
    public Wallet getWallet() {
        return wallet;
    }

    public double getWalletBalance() {
        return wallet.getBalance();
    }
    public String getWalletName(){
        return wallet.getName();
    }

}
