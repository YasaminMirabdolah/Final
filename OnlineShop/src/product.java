import java.util.*;

public class product extends Things {
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
                "Comments : "+Comments.toString()+"\n=================================================================\n";
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

    public Category getCategory() {
        return category;
    }

    public double getScreenSize() {
        return ScreenSize;
    }

    public void setScreenSize(double screenSize) {
        ScreenSize = screenSize;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
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
        return "Category : "+category+"\nName of the product : "+name+"\n"+"Price of the Product : "+price+"\n"+
                "Inventory Quantity : "+InventoryQuantity+"\n"+"Seller's name :  "+sellerName+"\n"+"Screen size : "+
                ScreenSize+"\n"+"Extra Data : "+extraData+"\n"+
                "Comments : "+Comments.toString()+"\n=================================================================\n";
    }
}













//2. کتاب
class Books extends product{
    public final Category category = Category.Books;
    public String publisher;
    public String writer;
    public String extraData;

    public Books(String name, double price , int InventoryQuantity , String sellerName ,String writer,
                   String publisher , String extraData,String commentfromtheseller){
     super(name,price ,InventoryQuantity,sellerName,commentfromtheseller);
        this.writer=writer;
        this.publisher=publisher;
        this.extraData=extraData;

    }
    public Books(String name, double price , int InventoryQuantity , String sellerName,String writer,
                   String publisher , String extraData){
       super(name,price,InventoryQuantity,sellerName);
       this.writer=writer;
       this.publisher=publisher;
       this.extraData=extraData;
    }

    public Category getCategory() {
        return category;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
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
        return "Category : "+category+"\nName of the product : "+name+"\n"+"Price of the Product : "+price+"\n"+
                "Inventory Quantity : "+InventoryQuantity+"\n"+"Seller's name :  "+sellerName+"\n"+"writer : "+
                writer+"\n"+"Writer : "+writer+"\n"+"Extra Data : "+extraData+"\n"+
                "Comments : "+Comments.toString()+"\n=================================================================\n";
    }


}








//3. پوشاک
class Clothing extends product {
    public final Category category = Category.Clothing;
    public String color;
    public String extraData;

    public Clothing(String name, double price, int InventoryQuantity, String sellerName, String color
            , String extraData, String commentfromtheseller) {
        super(name, price, InventoryQuantity, sellerName, commentfromtheseller);
        this.color = color;
        this.extraData = extraData;

    }

    public Clothing(String name, double price, int InventoryQuantity, String sellerName, String color, String extraData) {
        super(name, price, InventoryQuantity, sellerName);
        this.color = color;
        this.extraData = extraData;

    }
    public Category getCategory() {
        return category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
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
        return "Category : "+category+"\nName of the product : "+name+"\n"+"Price of the Product : "+price+"\n"+
                "Inventory Quantity : "+InventoryQuantity+"\n"+"Seller's name :  "+sellerName+"\n"+"color : "+
                color+"\n"+"Extra Data : "+extraData+"\n"+
                "Comments : "+Comments.toString()+"\n=================================================================\n";
    }
}














    //4.لوازم آرایشی و بهداشتی
    class Cosmetics extends product {
        public final Category category = Category.Cosmetics;
        public String extraData;
        public String Application;

        public Cosmetics(String name, double price, int InventoryQuantity, String sellerName, String Application
                , String extraData, String commentfromtheseller) {
            super(name, price, InventoryQuantity, sellerName, commentfromtheseller);
            this.Application = Application;
            this.extraData = extraData;

        }

        public Cosmetics(String name, double price, int InventoryQuantity, String sellerName, String Application
                , String extraData) {
            super(name, price, InventoryQuantity, sellerName);
            this.Application = Application;
            this.extraData = extraData;
        }

        public Category getCategory() {
            return category;
        }

        public String getApplication() {
            return Application;
        }

        public void setApplication(String application) {
            Application = application;
        }

        public String getExtraData() {
            return extraData;
        }

        public void setExtraData(String extraData) {
            this.extraData = extraData;
        }

        public void productaddComment(String comment) {
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

        public String toString() {
            return "Category : "+category+"\nName of the product : " + name + "\n" + "Price of the Product : " + price + "\n" +
                    "Inventory Quantity : " + InventoryQuantity + "\n" + "Seller's name :  " + sellerName + "\n" + "Application : " +
                    Application + "\n" + "Extra Data : " + extraData + "\n" +
                    "Comments : " + Comments.toString()+"\n=================================================================\n";
        }
    }

























        //5. لوازم خانه و آشپزخانه
        class HomeandKitchen extends product {
            public final Category category = Category.HomeandKitchen;
            public String extraData;
            public String Application;

            public HomeandKitchen(String name, double price, int InventoryQuantity, String sellerName, String Application
                    , String extraData, String commentfromtheseller) {
                super(name, price, InventoryQuantity, sellerName, commentfromtheseller);
                this.Application = Application;
                this.extraData = extraData;

            }

            public HomeandKitchen(String name, double price, int InventoryQuantity, String sellerName, String Application
                    , String extraData) {
                super(name, price, InventoryQuantity, sellerName);
                this.Application = Application;
                this.extraData = extraData;
            }

            public Category getCategory() {
                return category;
            }

            public String getApplication() {
                return Application;
            }

            public void setApplication(String application) {
                Application = application;
            }

            public String getExtraData() {
                return extraData;
            }

            public void setExtraData(String extraData) {
                this.extraData = extraData;
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
                return "category : "+category+"\nName of the product : "+name+"\n"+"Price of the Product : "+price+"\n"+
                        "Inventory Quantity : "+InventoryQuantity+"\n"+"Seller's name :  "+sellerName+"\n"+"Application : "+
                        Application+"\n"+"Extra Data : "+extraData+"\n"+
                        "Comments : "+Comments.toString()+"\n=================================================================\n";
            }
        }

