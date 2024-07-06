import java.util.*;

public class Shop {
    private  static final String name = "Yasamin's onlineShop";
    private static  final String WebURL = "WWW.YasaminsOnlineshop.com";
    private static final String number="0921-448-8999";
    private static ArrayList<Users> Accounts= new ArrayList<>();
    private static ArrayList<product> Product=new ArrayList<>();
    private static ArrayList<Order> orders= new ArrayList<>();
    private static ArrayList<Seller> sellersCanSell = new ArrayList<>();
    private static double profitEarned;




    public static String getName(){
    return name;
    }
    public static String getWebURL(){
    return WebURL;
    }
    public static String getNumber(){
    return number;
    }
    public static ArrayList<product> getProduct(){
        return Product;
    }

    public static ArrayList<Users> getAccounts() {
        return Accounts;
    }

    //Register
    public static void addAccont(Users user){
        Accounts.add(user);
    }
    public static void addSellersCanSell(Seller user){
        sellersCanSell.add(user);
    }

}
