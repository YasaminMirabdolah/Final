import java.util.*;

public class customer extends Users{
   public Role role=Role.customer;
   private String email;
   private String number;
   private String Address;
   private Wallet wallet;
   private ArrayList<product> cart;
   private ArrayList<Order> Order;
   private ArrayList<product> Bought;


   public customer(Role role, String name , String password , String email , String number, String Address){
      super(role , name , password);
      this.email=email;
      this.number=number;
      this.Address=Address;
      double balance=0;
      Wallet wallet=new Wallet(name,balance);

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

   public ArrayList<Order> getOrder() {
      return Order;
   }

   public ArrayList<product> getBought() {
      return Bought;
   }

   public ArrayList<product> getCart() {
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

   public void setBought(ArrayList<product> bought) {
      Bought = bought;
   }

   public void setCart(ArrayList<product> cart) {
      this.cart = cart;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setNumber(String number) {
      this.number = number;
   }

   public void setOrder(ArrayList<Order> order) {
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


}
