
public class Order {
    Product product;
    int qty;
    Date datePurchased;

    Order(Product product, int qty, Date purchaseDate){
        this.product = product;
        this.qty = qty;
        this.datePurchased = purchaseDate;

    }

    public double total(){
        return product.total(qty);
    }


}
