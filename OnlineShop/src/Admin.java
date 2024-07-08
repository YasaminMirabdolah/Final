import java.lang.reflect.Array;
import java.util.*;

public class Admin  extends Users{
    public Role role=Role.Admin;
    private String email;
    private static ArrayList<Users> requestforAdminAccount = new ArrayList<>();
    private static ArrayList<Seller> requestforsellingProduct = new ArrayList<>();
    private static ArrayList<Users> requestformoney=new ArrayList<>();
    private  static ArrayList<Cart> requestforbuyingProduct=new ArrayList<>();


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
    public  void Accepted(Admin admin){

        Shop.addAccont(admin);
        requestforAdminAccount.remove(admin);
    }
    public  void Remove(Admin admin){
        requestforAdminAccount.remove(admin);
    }
    public static void viewRequestforAdminAccount(Users admin) {
        Scanner input = new Scanner(System.in);
        Iterator<Users> iterrequest = requestforAdminAccount.iterator();
        for (int i = 0; i <= requestforAdminAccount.size(); i++) {
            if (i == requestforAdminAccount.size()) {
                System.out.println("last request");
                Main.adminService(admin);
            }
            else if (i < requestforAdminAccount.size()) {

                Users req = iterrequest.next();
                System.out.println(req);
                System.out.println("1)Accept" + "\n" + "2)remove\n" + "3)Back\n"+"=================================================================");
                int x = input.nextInt();
                if (x == 3) {
                    Main.adminService(admin);
                    break;
                } else if (x == 1) {
                    ((Admin) admin).Accepted((Admin)req);
                    Main.adminService(admin);
                    continue;
                }else if(x==2){
                    ((Admin) admin).Remove((Admin)req);
                    Main.adminService(admin);
                    continue;
                }

            }


        }

    }





    public static void addRequestforsellingProduct(Seller user){
        requestforsellingProduct.add(user);
    }
    public static ArrayList<Seller> getRequestforsellingProduct() {
        return requestforsellingProduct;
    }

    public void Acceptedseller(Seller seller){

        Shop.addSellersCanSell(seller);
        requestforsellingProduct.remove(seller);
    }
    public void Removeseller(Seller seller){
        requestforsellingProduct.remove(seller);
    }
    public static void viewrequestforsellingProduct(Users admin) {
        Scanner input = new Scanner(System.in);
        Iterator<Seller> iterrequest = requestforsellingProduct.iterator();
        for (int i = 0; i <= requestforsellingProduct.size(); i++) {
            if (i == requestforsellingProduct.size()) {
                System.out.println("last request");
                Main.adminService(admin);
            }
            else if (i < requestforsellingProduct.size()) {

                Seller req = iterrequest.next();
                System.out.println(req);
                System.out.println("1)Accept" + "\n" + "2)remove\n" + "3)Back\n"+"=================================================================");
                int x = input.nextInt();
                if (x == 3) {
                    Main.adminService(admin);

                    break;
                } else if (x == 1) {
                    ((Admin) admin).Acceptedseller(req);
                    Main.adminService(admin);

                    continue;
                }else if(x==2){
                    ((Admin) admin).Removeseller(req);
                    Main.adminService(admin);
                    continue;
                }

            }


        }

    }



























    public static ArrayList<Cart> getRequestforbuyingProduct() {
        return requestforbuyingProduct;
    }
    public static void addRequestforbuyingProduct(Cart order){
        requestforbuyingProduct.add(order);

    }
    public void Accepted(Cart order){

        customer c=order.getCustomer();
        Seller s=order.getSeller();
        double totalprice=(order.getPrice())*(order.getNumber());
        double moneyc=(-1*totalprice)*90/100;
        double moneys=totalprice*90/100;
        double profitforshop=totalprice*10/100;
        s.addmoney(moneys);
        c.addmoney(moneyc);
        Shop.addProfit(profitforshop);
        requestforbuyingProduct.remove(order);

    }
    public void Remove(Cart order){
        requestforbuyingProduct.remove(order);
    }
    public static void viewrequestforbuyingProduct(Users admin) {
        Scanner input = new Scanner(System.in);
        Iterator<Cart> iterrequest = requestforbuyingProduct.iterator();
        for (int i = 0; i <= requestforbuyingProduct.size(); i++) {
            if (i == requestforbuyingProduct.size()) {
                System.out.println("last request");
                Main.adminService(admin);
            }
           else if (i < requestforbuyingProduct.size()) {

                Cart req = iterrequest.next();
                System.out.println(req);
                System.out.println("1)Accept" + "\n" + "2)remove\n" + "3)Back\n"+"=================================================================");
                int x = input.nextInt();
                if (x == 3) {
                    Main.adminService(admin);
                    break;
                } else if (x == 1) {
                    ((Admin) admin).Accepted(req);
                    Main.adminService(admin);
                    continue;
                }else if(x==2){
                    ((Admin) admin).Remove(req);
                    Main.adminService(admin);
                    continue;
                }

            }


        }

    }













    public static ArrayList<Users> getRequestformoney() {
        return requestformoney;
    }
    public static void addRequestformoney(Users user){
        requestformoney.add(user);

    }
    public void Accepted(Users user){

        if(user instanceof customer){
            ((customer) user).addmoney(user.getRequestmoney());
        }else if (user instanceof Seller){
            ((Seller) user).addmoney(getRequestmoney());
        }requestformoney.remove(user.getRequestmoney());
    }
    public void Remove(Users user){
        requestformoney.remove(user);
    }
    public static void viewRequestmoney(Users admin) {
        Scanner input = new Scanner(System.in);
        Iterator<Users> iterrequest = requestformoney.iterator();
        for (int i = 0; i <= requestformoney.size(); i++) {
            if (i == requestformoney.size()) {
                System.out.println("last request");
                Main.adminService(admin);
            }
           else if (i < requestformoney.size()) {

                Users req = iterrequest.next();
                System.out.println(req);
                System.out.println("1)Accept" + "\n" + "2)remove\n" + "3)Back\n"+"=================================================================");
                int x = input.nextInt();
                if (x == 3) {
                    Main.adminService(admin);
                    break;
                } else if (x == 1) {
                    ((Admin) admin).Accepted(req);
                    Main.adminService(admin);
                    continue;
                }else if(x==2){
                    ((Admin) admin).Remove(req);
                    Main.adminService(admin);
                    continue;
                }

            }


        }

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
        System.out.println("Customer's wallet's balance:" + ((customer) s).getWallet());
        System.out.println("Customer Shopping cart: "+ ((customer) s).getCart());
        System.out.println("Customer's Order List : "+ ((customer) s).getOrder());
        System.out.println("Customer's List of Products Purchased : "+ ((customer) s).getBought());
    }
}
