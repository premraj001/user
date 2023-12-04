import java.io.*;
import java.util.Scanner;

class Employee {
    int empId;
    String name;
    String position;
    double salary;
}

public class EmployeeDatabase {

    static Scanner scanner = new Scanner(System.in);

    // Method to add a new record to the "employees.txt" file
    static void addRecord() throws IOException {
        Employee emp = new Employee();
        System.out.print("Enter Employee ID: ");
        emp.empId = scanner.nextInt();
        System.out.print("Enter Name: ");
        emp.name = scanner.next();
        System.out.print("Enter Position: ");
        emp.position = scanner.next();
        System.out.print("Enter Salary: ");
        emp.salary = scanner.nextDouble();

        // Using PrintWriter to write employee information to the file
        PrintWriter writer = new PrintWriter(new FileWriter("employees.txt", true));
        writer.printf("%d %s %s %.2f%n", emp.empId, emp.name, emp.position, emp.salary);
        System.out.println("Record added successfully.");
        writer.close();
    }

    // Method to display all records from the "employees.txt" file
    static void displayRecords() throws IOException {
        // Using Scanner to read employee records from the file
        Scanner fileScanner = new Scanner(new File("employees.txt"));
        System.out.println("Employee Records:");
        while (fileScanner.hasNext()) {
            // Reading and displaying each employee record from the file
            displayEmployeeRecord(fileScanner.nextInt(), fileScanner.next(), fileScanner.next(), fileScanner.nextDouble());
        }
        fileScanner.close();
    }

    // Method to search for a specific employee record by ID
    static void searchRecord(int empId) throws IOException {
        // Using Scanner to search for the employee record with the specified ID
        Scanner fileScanner = new Scanner(new File("employees.txt"));
        boolean found = false;
        while (fileScanner.hasNext()) {
            int currentEmpId = fileScanner.nextInt();
            String name = fileScanner.next();
            String position = fileScanner.next();
            double salary = fileScanner.nextDouble();

            if (currentEmpId == empId) {
                found = true;
                // Displaying the found employee record
                displayEmployeeRecord(currentEmpId, name, position, salary);
                break;
            }
        }
        fileScanner.close();
        // Displaying a message if the employee record is not found
        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    // Method to display a specific employee record
    static void displayEmployeeRecord(int empId, String name, String position, double salary) {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Salary: $" + salary);
        System.out.println("-----------------------");
    }

    // Method to handle IOException and display an error message
    static void handleIOException(String operation) {
        System.err.println("Error opening file for " + operation + ".");
    }

    // Method to display the menu options
    static void displayMenu() {
        System.out.println("Employee Database Menu:");
        System.out.println("1. Add Record");
        System.out.println("2. Display Records");
        System.out.println("3. Search Record");
        System.out.println("4. Modify Record");
        System.out.println("5. Delete Record");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
    
    // Main method to run the Employee Database program
    public static void main(String[] args) {
            // Displaying the menu and taking user input
            displayMenu();
            int choice = scanner.nextInt();
        while (choice != 6) {
            try {
                // Switch statement to handle user's menu choice
                switch (choice) {
                    case 1:
                        addRecord();
                        break;
                    case 2:
                        displayRecords();
                        break;
                    case 3:
                        System.out.print("Enter Employee ID to search: ");
                        int searchId = scanner.nextInt();
                        searchRecord(searchId);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IOException e) {
                // Handling IOException when performing file operations
                handleIOException("operation");
            }
        } 
    }

}
