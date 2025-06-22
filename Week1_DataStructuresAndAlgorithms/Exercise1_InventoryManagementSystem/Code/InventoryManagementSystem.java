import java.util.HashMap;
import java.util.Scanner;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setProductName(String name) { this.productName = name; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Product ID: " + productId +
                ", Name: " + productName +
                ", Quantity: " + quantity +
                ", Price: " + price;
    }
}

class InventoryManager {
    private HashMap<Integer, Product> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("✅ Product added successfully.");
    }

    public void updateProduct(int productId, String name, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("✅ Product updated successfully.");
        } else {
            System.out.println("❌ Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("✅ Product deleted successfully.");
        } else {
            System.out.println("❌ Product not found.");
        }
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("📦 Inventory is empty.");
            return;
        }
        System.out.println("📋 Inventory List:");
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}


public class InventoryManagementSystem {
    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Inventory Management Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    manager.addProduct(new Product(id, name, qty, price));
                    break;
                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int uid = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int newQty = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double newPrice = scanner.nextDouble();
                    manager.updateProduct(uid, newName, newQty, newPrice);
                    break;
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int did = scanner.nextInt();
                    manager.deleteProduct(did);
                    break;
                case 4:
                    manager.displayInventory();
                    break;
                case 5:
                    System.out.println("👋 Exiting Inventory System. Goodbye!");
                    return;
                default:
                    System.out.println("❗ Invalid choice, try again.");
            }
        }
    }
}
