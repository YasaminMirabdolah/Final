public class Cart  {
    private customer customer;
    private Seller seller;
    private product product;
    private int number;
    private double price;
    public Cart(product product , int number , double price ,customer customer , Seller seller ){
        this.customer=customer;
        this.number=number;
        this.product=product;
        this.seller=seller;
        this.price=price;
    }
    public customer getCustomer(){
        return customer;
    }

    public Seller getSeller(){
        return seller;
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


    @Override
    public String toString() {
        return "name of product : "+ product.getName()+"\nnumber of product : "+number+"\nTotal Price : "+number*price+
                "\ncustomer's name : "+customer.getName()+"\nSeller's name : "+seller.getName();
    }
}
