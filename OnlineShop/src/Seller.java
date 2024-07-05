import java.util.*;

public class Seller extends Users{
    public Role role=Role.Seller;
    private ArrayList<product> productsToSell= new ArrayList<>();
    private Wallet wallet;
    public Seller(Role role , String companyname , String password){
        super(role , companyname , password);
        double balance=0;
        Wallet wallet=new Wallet(companyname,balance);

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
