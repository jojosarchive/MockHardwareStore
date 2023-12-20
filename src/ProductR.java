public class ProductR extends Product {

    ProductR(String n, double p){
        super(n, p, 'R');

    }

    double total(int qty){
        return qty * price;
    }
}