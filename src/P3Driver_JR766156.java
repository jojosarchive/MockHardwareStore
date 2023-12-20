

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class P3Driver_JR766156 {
    static ArrayList<Order> List = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        int option;

        Scanner scanner = new Scanner(new File("inventory.txt"));

        while (scanner.hasNextLine()) {
            // Read each line from the file and split it into parts using a comma as the delimiter
            String line = scanner.nextLine();
            String[] values = line.split(",");
            String name = values[0];
            double price = Double.parseDouble(values[1]);
            char type = values[2].charAt(0);

            if (type == 'R') {
                new ProductR(name, price);
            } else if (type == 'B') {
                new ProductB(name, price);
            } else if (type == 'S') {
                new ProductS(name, price);
            }


        }

        //refrenced from my project 2 file reader

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("1. Show the inventory on the screen");
        System.out.println("2. Make on order");
        System.out.println("3. Review the order");
        System.out.println("4. Quit the program");
        System.out.println("-----------------------------------------------------------------------------------");


        Scanner scan = new Scanner(System.in);
        do {


            option = scan.nextInt();
            while (true) {
                if (option == 1) {
                    System.out.println("-----------------------------------------------------------------------------------");
                    inventory();
                    System.out.println("-----------------------------------------------------------------------------------");
                    break;
                } else if (option == 2) {
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("Enter the product name:");
                    String productName = scan.next();
                    System.out.println("Enter quantity:");
                    int quantity = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Enter purchase date (MM/dd/yyyy):");
                    String purchaseDateS = scan.nextLine();
                    Date purchased = new Date(purchaseDateS);
                    userOrder(productName, quantity, purchased);

                    System.out.println("-----------------------------------------------------------------------------------");
                    break;
                } else if (option == 3) {
                    System.out.println("-----------------------------------------------------------------------------------");
                    reviewUserOrders();
                    System.out.println("-----------------------------------------------------------------------------------");
                    break;
                } else if (option == 4) {
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("bye");
                    System.out.println("-----------------------------------------------------------------------------------");
                    break;
                }

            }
        } while (option != 4);
    }


    public static void inventory() {
        int i = 0;
        while (Product.inventory[i] != null) {
            System.out.println(Product.inventory[i++]);
        }
    }
// referenced from my project 2 method "inventory"


    public static void userOrder(String productName, int quantity, Date purchaseDate) {
        Product selectedProduct = findProductByName(productName);
        if (selectedProduct != null) {
            Order order = new Order(selectedProduct, quantity, purchaseDate);
            List.add(order);
            System.out.println("Order added successfully!");
        }
    }
    private static Product findProductByName(String productName) {
        int i;
        for (i = 0; i < Product.invSize; i++) {
            if (Product.inventory[i].name.equals(productName)) {
                return Product.inventory[i];
            }

        }
        return null;
    }
    //refrenced from my project 2 method "FindName"
    private static void reviewUserOrders() {
        for (Order order : List) {
            System.out.println("Name: " + order.product.name + "   " + "Price: " + order.product.price + "   "  + "type: " +order.product.type + "   "  + "quantity: " + order.qty + "   "  + "date: " + order.datePurchased + "   " + "total" + order.total());
        }
    }

}