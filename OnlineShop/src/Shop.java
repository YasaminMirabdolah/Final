import java.util.*;

public class Shop {
    private  static final String name = "Yasamin's onlineShop";
    private static  final String WebURL = "WWW.YasaminsOnlineshop.com";
    private static final String number="0921-448-8999";
    private static Set<Users> Accounts= new HashSet<>();
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

    public static Set<Users> getAccounts() {
        return Accounts;
    }

    //Register
    public static void addAccont(Users user){
        Accounts.add(user);
    }
    public static void addSellersCanSell(Seller user){
        sellersCanSell.add(user);
    }
    public static void addProduct(product product){
       Product.add(product);
    }

    public static void viewProduct(Users costumer){
        Scanner input=new Scanner(System.in);
        Iterator<product>iterproduct=Product.iterator();
        for(int i=0 ;i<=Product.size();i++){
            if (i==Product.size()) {
                System.out.println("last product");
                Main.customerService(costumer);
            }
        if (i<Product.size()) {

            product pro = iterproduct.next();
            System.out.println(pro);
            System.out.println("1)add to Shopping cart" + "\n" + "2)next product" + "\n" + "3)Comment\n" + "4)Back\n" + "=================================================================");
            int x = input.nextInt();
            if (x == 4) {
                Main.customerService(costumer);
                break;
            } else if (x == 2) {
                continue;
            } else if (x == 3) {
                //add comment
                continue;
            } else if (x == 1) {
                //add to shoping cart
                int quantity = pro.getInventoryQuantity();
                pro.setInventoryQuantity(quantity - 1);
                continue;

            }

        }


        }





    }
   // public static void searchProduct(String name){

   // }
   // public static void searchProduct(String sellername){

    //}
   // public static void searchProduct(double price){

   // }

}
