import java.lang.reflect.Array;
import java.util.*;

public class Admin  extends Users{
    public Role role=Role.Admin;
    private String email;
    private ArrayList<Users> requestforAdminAccount = new ArrayList<>();
    private ArrayList<Seller> requestforsellingProduct = new ArrayList<>();
    private ArrayList<Order> requestforbuyingProduct=new ArrayList<>();
    public Admin(Role role , String name , String password, String email){
        super(role, name , password);
        this.email=email;
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
}
