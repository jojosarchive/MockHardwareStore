class ProductB extends Product {

    ProductB(String n, double p) {
        super(n, p, 'B');
    }

    @Override
    double total(int qty) {

        if (qty < 100) {
            return price * qty;
        } else if (qty <= 500) {
            return (price * qty) * .95;
        } else if (qty <= 1500) {
            return (price * qty) * .85;
        } else {
            return (price * qty) * .75;
        }
    }
}