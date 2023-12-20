public abstract class Product {

    String name;
    double price;
    char type;
    static int invSize;
    static Product[] inventory = new Product[2000];

    public Product(String n, double p, char t) {

        inventory[invSize++] = this;
        this.name = n;
        this.price = p;
        this.type = t;
    }

    abstract double total(int qty);

    public String toString() {

        return name + price + type;
    }
}