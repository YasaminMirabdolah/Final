import java.util.*;

public class Shop {
    private  static final String name = "Yasamin's onlineShop";
    private static  final String WebURL = "WWW.YasaminsOnlineshop.com";
    private static final String number="0921-448-8999";
    private static ArrayList<Users> Accounts;
    private static ArrayList<product> Product;
    private static ArrayList<Order> orders;
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

    public static void setAccounts(ArrayList<Users> accounts) {
        Accounts = accounts;
    }


//Register
    public static void addAccont(Users user){
        Accounts.add(user);
    }



}
