import java.util.*;

public class product {
    public  String name;
    public  double price;
    public  int InventoryQuantity;
    public String  sellerName;
    public  ArrayList<String> Comments=new ArrayList<>();

    public product(){}
    public product(String name, double price , int InventoryQuantity , String sellerName , String commentfromtheseller){
        this.name=name;
        this.price=price;
        this.InventoryQuantity=InventoryQuantity;
        this.sellerName=sellerName;
        Comments.add(commentfromtheseller);
    }
    public product(String name, double price , int InventoryQuantity , String sellerName){
        this.name=name;
        this.price=price;
        this.InventoryQuantity=InventoryQuantity;
        this.sellerName=sellerName;

    }

    public void productaddComment(String comment){
        Comments.add(comment);

    }

    public String getSellerName() {
        return sellerName;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getComments() {
        return Comments;
    }

    public int getInventoryQuantity() {
        return InventoryQuantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComments(ArrayList<String> comments) {
        Comments = comments;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        InventoryQuantity = inventoryQuantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
    public String toString(){
        return "Name of the product : "+name+"\n"+"Price of the Product : "+price+"\n"+
                "Inventory Quantity : "+InventoryQuantity+"\n"+"Seller's name :  "+sellerName+"\n"+
                "Comments : "+Comments.toString();
    }
}














//1. لواز الکترونیک
class Electronics extends product{
    public final Category category = Category.Electronics;
    public  String extraData;
    public  double ScreenSize;

    public Electronics(String name, double price , int InventoryQuantity , String sellerName , String extraData, double ScreenSize,
            String commentfromtheseller){
       super(name , price , InventoryQuantity, sellerName , commentfromtheseller);
       this.extraData=extraData;
       this.ScreenSize=ScreenSize;
    }
    public Electronics(String name, double price , int InventoryQuantity , String sellerName , String extraData, double ScreenSize){
      super(name, price , InventoryQuantity, sellerName);
      this.ScreenSize=ScreenSize;
      this.extraData=extraData;

    }

    public String getCategory() {
        return Category;
    }

    public double getScreenSize() {
        return ScreenSize;
    }

    public String getExtraData() {
        return extraData;
    }
    public void productaddComment(String comment){
        Comments.add(comment);

    }

    public String getSellerName() {
        return sellerName;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getComments() {
        return Comments;
    }

    public int getInventoryQuantity() {
        return InventoryQuantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComments(ArrayList<String> comments) {
        Comments = comments;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        InventoryQuantity = inventoryQuantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
    public String toString(){
        return "Name of the product : "+name+"\n"+"Price of the Product : "+price+"\n"+
                "Inventory Quantity : "+InventoryQuantity+"\n"+"Seller's name :  "+sellerName+"\n"+
                "Comments : "+Comments.toString();
    }
}

//2. کتاب
class Books extends product{
    public String publisher;
    public String writer;
    public String extraData;

    public product(String name, double price , int InventoryQuantity , String sellerName , String commentfromtheseller){
        this.name=name;
        this.price=price;
        this.InventoryQuantity=InventoryQuantity;
        this.sellerName=sellerName;
        Comments.add(commentfromtheseller);
    }
    public product(String name, double price , int InventoryQuantity , String sellerName){
        this.name=name;
        this.price=price;
        this.InventoryQuantity=InventoryQuantity;
        this.sellerName=sellerName;

    }


}

//3. پوشاک
class Clothing extends product{
    public String color;
    public String extraData;

    public product(String name, double price , int InventoryQuantity , String sellerName , String commentfromtheseller){
        this.name=name;
        this.price=price;
        this.InventoryQuantity=InventoryQuantity;
        this.sellerName=sellerName;
        Comments.add(commentfromtheseller);
    }
    public product(String name, double price , int InventoryQuantity , String sellerName){
        this.name=name;
        this.price=price;
        this.InventoryQuantity=InventoryQuantity;
        this.sellerName=sellerName;

    }

}

//4.لوازم آرایشی و بهداشتی
class Cosmetics extends product{
    public String extraData;
    public String Application;

    public product(String name, double price , int InventoryQuantity , String sellerName , String commentfromtheseller){
        this.name=name;
        this.price=price;
        this.InventoryQuantity=InventoryQuantity;
        this.sellerName=sellerName;
        Comments.add(commentfromtheseller);
    }
    public product(String name, double price , int InventoryQuantity , String sellerName){
        this.name=name;
        this.price=price;
        this.InventoryQuantity=InventoryQuantity;
        this.sellerName=sellerName;

    }
}


//5. لوازم خانه و آشپزخانه
class HomeandKitchen extends product{
    public String extraData;
    public String Application;

    public product(String name, double price , int InventoryQuantity , String sellerName , String commentfromtheseller){
        this.name=name;
        this.price=price;
        this.InventoryQuantity=InventoryQuantity;
        this.sellerName=sellerName;
        Comments.add(commentfromtheseller);
    }
    public product(String name, double price , int InventoryQuantity , String sellerName){
        this.name=name;
        this.price=price;
        this.InventoryQuantity=InventoryQuantity;
        this.sellerName=sellerName;

    }

}

