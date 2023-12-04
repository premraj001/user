// import java.util.Scanner;
// import java.io.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Employee{
    int empId;
    String empName;
    String Post;
    double salary;
}

public class copy{
    static Scanner scanner=new Scanner(System.in);
    static void addRecord() throws IOException
    {
        Employee emp = new Employee();
        System.out.println("Enter Employee Id");
        emp.empId= scanner.nextInt();
        System.out.println("Enter Employee Salary");
        emp.salary= scanner.nextDouble();

        PrintWriter writer = new PrintWriter(new FileWriter("employees.txt", true));
        writer.printf("%d %s %s %.2f%n", emp.empId, emp.name, emp.position, emp.salary);
        System.out.println("Record added successfully.");
        writer.close();
    }

    public static void main(String []args) throws IOException
    {
       addRecord();
    }

}

