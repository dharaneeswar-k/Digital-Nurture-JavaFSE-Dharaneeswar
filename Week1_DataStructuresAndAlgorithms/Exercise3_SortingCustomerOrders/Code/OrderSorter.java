package Week1_DataStructuresAndAlgorithms.Exercise3_SortingCustomerOrders.Code;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderID: " + orderId + ", Customer: " + customerName + ", Total: ₹" + totalPrice;
    }
}

public class OrderSorter {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void displayOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order(1, "Arun", 2500.00),
                new Order(2, "Priya", 700.00),
                new Order(3, "Kumar", 5600.00),
                new Order(4, "Divya", 3300.00)
        };

        System.out.println("Original Orders:");
        displayOrders(orders);

        bubbleSort(orders);
        System.out.println("\nOrders after Bubble Sort:");
        displayOrders(orders);

        orders = new Order[] {
                new Order(1, "Arun", 2500.00),
                new Order(2, "Priya", 700.00),
                new Order(3, "Kumar", 5600.00),
                new Order(4, "Divya", 3300.00)
        };

        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nOrders after Quick Sort:");
        displayOrders(orders);
    }
}
