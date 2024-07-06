import java.lang.reflect.Array;
import java.util.*;

public class Admin  extends Users{
    public Role role=Role.Admin;
    private String email;
    private static ArrayList<Users> requestforAdminAccount = new ArrayList<>();
    private static ArrayList<Seller> requestforsellingProduct = new ArrayList<>();
    private  static ArrayList<Order> requestforbuyingProduct=new ArrayList<>();


    public Admin(Role role , String name , String password, String email){
        super(role, name , password);
        this.email=email;
    }


    public static void addRequestforAdminAccount(Users user){
        requestforAdminAccount.add(user);
    }
    public static ArrayList<Users> getRequestforAdminAccount() {
        return requestforAdminAccount;
    }
    public void Accepted(Admin admin){
        requestforAdminAccount.remove(admin);
        Shop.addAccont(admin);
    }
    public void Remove(Admin admin){
        requestforAdminAccount.remove(admin);
    }


    public void Accepted(Seller seller){
        requestforsellingProduct.remove(seller);
        Shop.addSellersCanSell(seller);
    }
    public void Remove(Seller seller){
        requestforsellingProduct.remove(seller);
    }


    public void Accepted(Order order){

    }


    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Role getRole() {
        return role;
    }



    public void viewInfo(Users  s){
        System.out.println("customer's name : " + s.getName());
        System.out.println("Customer's password : "+ s.getPassword());
        System.out.println("Customer's Address : " + ((customer) s).getAddress());
        System.out.println("Customer's number : " +((customer) s).getNumber());
        System.out.println("Customer's Email : "+ ((customer) s).getEmail());
        System.out.println("Customer's wallet's balance:" + ((customer) s).getWalletBalance());
        System.out.println("Customer Shopping cart: "+ ((customer) s).getCart());
        System.out.println("Customer's Order List : "+ ((customer) s).getOrder());
        System.out.println("Customer's List of Products Purchased : "+ ((customer) s).getBought());
    }
}
