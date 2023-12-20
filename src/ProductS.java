public class ProductS extends Product {

    ProductS(String n, double p) {
        super(n, p, 'S');
    }

    double total(int qty) {
        boolean season = true;
        if (season) {
            return (price * qty) * .6;
        } else {
            return price * qty;
        }
    }
}