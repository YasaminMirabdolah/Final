import java.util.*;

public class Shop {
    private  static final String name = "Yasamin's onlineShop";
    private static  final String WebURL = "WWW.YasaminsOnlineshop.com";
    private static final String number="0921-448-8999";
    private static ArrayList<Users> Accounts= new ArrayList<>();
    private static ArrayList<product> Product=new ArrayList<>();
    private static ArrayList<Cart> orders= new ArrayList<>();
    private static ArrayList<Seller> sellersCanSell = new ArrayList<>();
    private static double profitEarned=0;




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

    public static ArrayList<Cart> getOrders() {
        return orders;
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

    public static ArrayList<Seller> getSellersCanSell() {
        return sellersCanSell;
    }

    public static double getProfitEarned(){
        return profitEarned;
    }
    public static void addProfit(double ProfitEarned){
        profitEarned=profitEarned+ProfitEarned;
    }



    public static void viewProduct() {
        Scanner input = new Scanner(System.in);
        Iterator<product> iterproduct = Product.iterator();
        for (int i = 0; i <= Product.size(); i++) {
            if (i == Product.size()) {
                System.out.println("last product");
                Main.menu();
            }
            if (i < Product.size()) {

                product pro = iterproduct.next();
                System.out.println(pro);
                System.out.println("1)next product" + "\n" + "2)Back\n" + "=================================================================");
                int x = input.nextInt();
                if (x == 2) {
                    Main.menu();
                    break;
                } else if (x == 1) {
                    continue;
                }

            }


        }

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
                System.out.println("Write your comment (do not use space) : ");
                String comment =input.next();
                pro.productaddComment(comment);
                System.out.println("your comment is added");
                continue;
            }
            else if (x == 1) {
                System.out.println("Enter the number of product you want to add to your Shopping cart");
                int n=input.nextInt();
                if(n<=pro.getInventoryQuantity()) {
                    ((customer) costumer).addToShopingCart(pro , n , pro.getPrice() , ((customer) costumer) ,  pro.getSeller());
                    int quantity =pro.getInventoryQuantity();
                    int newquantity=quantity-n;
                    pro.setInventoryQuantity(newquantity);
                    continue;
                }
                else if(n>pro.getInventoryQuantity()){
                    System.out.println("Insufficient Inventory");
                    viewProduct(costumer);
                }
                continue;

            }else{
                System.out.println("invalid input");
               viewProduct(costumer);
            }

        }


        }





    }
   public static void searchProduct(Users costumer) {
       Scanner input = new Scanner(System.in);
       boolean found=false;
       System.out.println("Which one you want to search : 1)Name of the product  2)name of the seller  3)Price of the product  4)Back");
       int x = input.nextInt();
       ArrayList<product> foundProduct = new ArrayList<>();
       if(x==4){
           Main.customerService(costumer);
       }
       if (x == 1) {
           System.out.println("Please Enter the name of the product :");
           String name = input.next();
           for (product product : Product) {
               if (name.equals(product.getName())) {
                   foundProduct.add(product);
                   found=true;

               }
           }if(found==false){
               System.out.println("Can't find the product");
           }
       }
       if (x == 2) {
           System.out.println("Please Enter the name of the seller :");
           String sellername = input.next();
           for (product product : Product) {
               if (sellername.equals(product.getSeller())) {
                   foundProduct.add(product);
                   found = true;

               }
           }
           if (found == false) {
               System.out.println("Can't find the product");

           }
       }
       if(x==3){
           System.out.println("Please Enter the price of the product : ");
           double price=input.nextDouble();
           for(product product:Product){
               if(price==product.getPrice()){
                   foundProduct.add(product);
                   found=true;
               }
           } if (found == false) {
               System.out.println("Can't find the product");
           }
       }


       Iterator<product> iterproduct = foundProduct.iterator();
       for (int i = 0; i <= foundProduct.size(); i++) {
           if (i == foundProduct.size()) {
               Main.customerService(costumer);
           }
           if (i < foundProduct.size()) {

               product pro = iterproduct.next();
               System.out.println(pro);
               System.out.println("1)add to Shopping cart" + "\n" + "2)next product" + "\n" + "3)Comment\n" + "4)Back\n" + "=================================================================");
               int m = input.nextInt();
               if (m == 4) {
                   Main.customerService(costumer);
                   break;
               } else if (m == 2) {
                   continue;
               } else if (m == 3) {
                   System.out.println("Write your comment (do not use space) : ");
                   String comment =input.next();
                   pro.productaddComment(comment);
                   System.out.println("your comment is added");
                   continue;
               }
               else if (m == 1) {

                   System.out.println("Enter the number of product you want to add to your Shopping cart");
                   int n=input.nextInt();
                   if(n<=pro.getInventoryQuantity()) {
                       ((customer) costumer).addToShopingCart(pro , n , pro.getPrice() , ((customer) costumer) , pro.getSeller());
                       int quantity =pro.getInventoryQuantity();
                       int newquantity=quantity-n;
                       pro.setInventoryQuantity(newquantity);
                       continue;
                   }
                   else if(n>pro.getInventoryQuantity()){
                       System.out.println("Insufficient Inventory");
                       searchProduct(costumer);

                   }


               }else{
                   System.out.println("invalid input");
                   searchProduct(costumer);
               }

           }


       }
   }
   public static void addOrder(Cart pro){
        orders.add(pro);
   }

}




