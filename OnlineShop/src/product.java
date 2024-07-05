import java.util.*;

public class product {
    public  String name;
    public  double price;
    public  int InventoryQuantity;
    public String  sellerName;
    public  ArrayList<String> Comments;
}

//1. لواز الکترونیک
class Electronics extends product{
    public  String extraData;
    public  double ScreenSize;


}

//2. کتاب
class Books extends product{
    public String publisher;
    public String writer;

}

//3. پوشاک
class Clothing extends product{
    public String color;
    public String extraData;

}

//4.لوازم آرایشی و بهداشتی
class Cosmetics extends product{
    public String extraData;
    public String Application;
}


//5. لوازم خانه و آشپزخانه
class HomeandKitchen extends product{
    public String extraData;
    public String Application;

}

