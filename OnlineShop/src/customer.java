import java.util.*;

public class customer extends Users{
   public Role role=Role.customer;
   private String email;
   private String number;
   private String Address;
   private Wallet wallet=new Wallet();
   private ArrayList<Things> cart=new ArrayList<>();
   private ArrayList<Things> Order=new ArrayList<>();
   private ArrayList<Things> Bought=new ArrayList<>();


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

   public ArrayList<Things> getOrder() {
      return Order;
   }

   public ArrayList<Things> getBought() {
      return Bought;
   }

   public ArrayList<Things> getCart() {
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

   public void setBought(ArrayList<Things> bought) {
      Bought = bought;
   }

   public void setCart(ArrayList<Things> cart) {
      this.cart = cart;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setNumber(String number) {
      this.number = number;
   }

   public void setOrder(ArrayList<Things> order) {
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

   public void addToShopingCart(product Product){

      cart.add(Product);
   }


}
