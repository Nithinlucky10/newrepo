import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Inventory {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();

                    Product product = new Product(inventory.getAllProducts().size() + 1, name, price, quantity);
                    inventory.addProduct(product);
                    System.out.println("Product added successfully!");
                    break;
                case 2:
                    List<Product> products = inventory.getAllProducts();
                    if (products.isEmpty()) {
                        System.out.println("No products in the inventory.");
                    } else {
                        System.out.println("Products in Inventory:");
                        for (Product p : products) {
                            System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Price: $" + p.getPrice() + ", Quantity: " + p.getQuantity());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting Inventory Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
