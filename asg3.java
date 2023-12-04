import java.util.InputMismatchException;
import java.util.Scanner;

class Product {
    String name;
    int id;
    int quantity;
    double price;

    public Product(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }
}

public class asg3 {
    private static final int MAX_PRODUCTS = 100;
    private static Product[] inventory = new Product[MAX_PRODUCTS];
    private static int itemCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add record");
            System.out.println("2. Display Database");
            System.out.println("3. Search record");
            System.out.println("4. Delete record");
            System.out.println("5. Sort records");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addRecord(scanner);
                    break;
                case 2:
                    displayDatabase();
                    break;
                case 3:
                    searchRecord(scanner);
                    break;
                case 4:
                    deleteRecord(scanner);
                    break;
                case 5:
                    sortRecords();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void addRecord(Scanner scanner) {
        if (itemCount < MAX_PRODUCTS) {
            System.out.print("Enter product name: ");
            String name = scanner.next();

            int id = 0;
            boolean validId = false;
            while (!validId) {
                try {
                    System.out.print("Enter product ID: ");
                    id = scanner.nextInt();
                    validId = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for the product ID.");
                    // Clear the scanner buffer to avoid an infinite loop
                    scanner.next();
                }
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            System.out.print("Enter price: ");
            double price = scanner.nextDouble();

            inventory[itemCount++] = new Product(name, id, quantity, price);
            System.out.println("Record added successfully.");
        } else {
            System.out.println("Database is full. Cannot add more records.");
        }
    }

    private static void displayDatabase() {
        System.out.println("Inventory Database:");
        for (int i = 0; i < itemCount; i++) {
            System.out.println("Product ID: " + inventory[i].id +
                    ", Name: " + inventory[i].name +
                    ", Quantity: " + inventory[i].quantity +
                    ", Price: " + inventory[i].price);
        }
    }

    private static void searchRecord(Scanner scanner) {
        System.out.print("Enter the product ID to search: ");
        int searchId = scanner.nextInt();

        for (int i = 0; i < itemCount; i++) {
            if (inventory[i].id == searchId) {
                System.out.println("Product found:");
                System.out.println("Product ID: " + inventory[i].id +
                        ", Name: " + inventory[i].name +
                        ", Quantity: " + inventory[i].quantity +
                        ", Price: " + inventory[i].price);
                return;
            }
        }

        System.out.println("Product with ID " + searchId + " not found.");
    }

    private static void deleteRecord(Scanner scanner) {
        System.out.print("Enter the product ID to delete: ");
        int deleteId = scanner.nextInt();

        for (int i = 0; i < itemCount; i++) {
            if (inventory[i].id == deleteId) {
                // Move elements to fill the gap left by the deleted record
                for (int j = i; j < itemCount - 1; j++) {
                    inventory[j] = inventory[j + 1];
                }
                itemCount--;
                System.out.println("Record deleted successfully.");
                return;
            }
        }

        System.out.println("Product with ID " + deleteId + " not found.");
    }

    private static void sortRecords() {
        // Sort the array of products based on product IDs
        for (int i = 0; i < itemCount - 1; i++) {
            for (int j = 0; j < itemCount - 1 - i; j++) {
                if (inventory[j].id > inventory[j + 1].id) {
                    // Swap products
                    Product temp = inventory[j];
                    inventory[j] = inventory[j + 1];
                    inventory[j + 1] = temp;
                }
            }
        }

        System.out.println("Records sorted based on product IDs.");
    }
}
