import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "[" + productId + ", " + productName + ", " + category + "]";
    }
}

public class ECommerceSearch {

    public static Product linearSearch(Product[] products, int id) {
        for (Product product : products) {
            if (product.productId == id) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int id) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productId == id) {
                return products[mid];
            } else if (products[mid].productId < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] unsortedProducts = {
                new Product(102, "Shoes", "Footwear"),
                new Product(101, "Laptop", "Electronics"),
                new Product(103, "T-shirt", "Clothing"),
        };

        Product[] sortedProducts = new Product[unsortedProducts.length];
        for (int i = 0; i < unsortedProducts.length; i++) {
            sortedProducts[i] = unsortedProducts[i];
        }

        Arrays.sort(sortedProducts, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return Integer.compare(p1.productId, p2.productId);
            }
        });
        System.out.println("\nEnter the Product ID to Search : ");
        int searchId = scanner.nextInt();

        Product foundLinear = linearSearch(unsortedProducts, searchId);
        if (foundLinear != null) {
            System.out.println("Linear Search Result: " + foundLinear);
        } else {
            System.out.println("Linear Search Result: Product not found");
        }


        Product foundBinary = binarySearch(sortedProducts, searchId);
        if(foundBinary != null){
            System.out.println("Binary Search Result: "+ foundBinary);
        }else {
            System.out.println("Binary Search Result: Product not Found");
        }
    }
}
