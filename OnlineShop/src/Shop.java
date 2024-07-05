import java.util.*;

public class Shop {
    private  static final String name = "Yasamin's onlineShop";
    private static  final String WebURL = "WWW.YasaminsOnlineshop.com";
    private static final String number="0921-448-8999";
    private ArrayList<Users> Accounts;
    private ArrayList<product> Product;
    private ArrayList<Order> orders;
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
}
