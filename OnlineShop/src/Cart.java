public class Cart extends Things {
    private String customerName;
    private String sellerName;
    private product product;
    private int number;
    private double price;
    public Cart(product product , int number , double price , String customerName,String sellerName ){
        this.customerName=customerName;
        this.number=number;
        this.product=product;
        this.sellerName=sellerName;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public product getProduct() {
        return product;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getSellerName() {
        return sellerName;
    }

    @Override
    public String toString() {
        return "name of product : "+ product+"\nnumber of product : "+number+"\nTotal Price : "+number*price+
                "\ncustomer's name : "+customerName+"\nSeller's name : "+sellerName;
    }
}
