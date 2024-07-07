import java.util.*;

public class customer extends Users{
   public Role role=Role.customer;
   private String email;
   private String number;
   private String Address;
   private Wallet wallet=new Wallet();
   private ArrayList<Cart> cart=new ArrayList<>();
   private ArrayList<Cart> Order=new ArrayList<>();
   private ArrayList<Cart> Bought=new ArrayList<>();


   public customer(Role role, String name , String password , String email , String number, String Address){
      super(role , name , password);
      this.email=email;
      this.number=number;
      this.Address=Address;

   }



   @Override
   public String getName() {
      return super.getName();
   }

   @Override
   public String getPassword() {
      return super.getPassword();
   }

   @Override
   public void setName(String name) {
      super.setName(name);
   }

   @Override
   public void setPassword(String password) {
      super.setPassword(password);
   }

   @Override
   public Role getRole() {
      return role;
   }

   public String getAddress() {
      return Address;
   }

   public ArrayList<Cart> getOrder() {
      return Order;
   }

   public ArrayList<Cart> getBought() {
      return Bought;
   }

   public ArrayList<Cart> getCart() {
      return cart;
   }

   public String getEmail() {
      return email;
   }

   public String getNumber() {
      return number;
   }

   public void setAddress(String address) {
      Address = address;
   }

   public void setBought(ArrayList<Cart> bought) {
      Bought = bought;
   }

   public void setCart(ArrayList<Cart> cart) {
      this.cart = cart;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setNumber(String number) {
      this.number = number;
   }

   public void setOrder(ArrayList<Cart> order) {
      Order = order;
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





   public void addToShopingCart(product product , int number , double price , String customerName,String sellerName ){
   Cart newcart=new Cart(product , number , price, customerName, sellerName);
     cart.add(newcart);
   }







   public void viewCart(Users customer) {
      Scanner input = new Scanner(System.in);
      Iterator<Cart> iterproduct = cart.iterator();
      for (int i = 0; i <= cart.size(); i++) {
         if (i == cart.size()) {
            System.out.println("last product");
            Main.customerService(customer);
         }
         if (i < cart.size()) {

            Cart pro = iterproduct.next();
            System.out.println(pro);
            System.out.println("1)add to order list" + "\n" + "2)Empty the shopping list" + "\n" + "3)Next\n"+"4)Back\n" + "=================================================================");
            int m = input.nextInt();
            if(m==3){
               continue;
            }
            if (m == 4) {
               Main.customerService(customer);
               break;
            } else if (m == 2) {
               cart.clear();
            } else if (m == 1) {
               ((customer) customer).getOrder().add(pro);
               Shop.addOrder(pro);
               Admin.addRequestforbuyingProduct(pro);//requst for buying things (قسمت امتیازی)

            }
         }
      }
   }










   public void vieworder(Users customer) {
      Scanner input = new Scanner(System.in);
      Iterator<Cart> iterproduct =Order.iterator();
      for (int i = 0; i <= Order.size(); i++) {
         if (i == Order.size()) {
            System.out.println("last product");
            Main.customerService(customer);
         }
         if (i < Order.size()) {

            Cart pro = iterproduct.next();
            System.out.println(pro);

            }
         }
      }




   public void viewBought(Users customer) {
      Scanner input = new Scanner(System.in);
      Iterator<Cart> iterproduct =Bought.iterator();
      for (int i = 0; i <= Bought.size(); i++) {
         if (i == Bought.size()) {
            System.out.println("last product");
            Main.customerService(customer);
         }
         if (i < Bought.size()) {

            Cart pro = iterproduct.next();
            System.out.println(pro);

         }
      }
   }

}



