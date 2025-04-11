import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return id + " | " + name + " | ₹" + salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}

public class StreamExample {
    public static void main(String[] args) {
        // Create an ArrayList of Employees (Collection implementation)
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(101, "Ravi", 45000));
        empList.add(new Employee(102, "Seema", 55000));
        empList.add(new Employee(103, "Ajay", 30000));
        empList.add(new Employee(104, "Neha", 65000));
        empList.add(new Employee(105, "Vikas", 25000));

        System.out.println("---- All Employees ----");
        empList.forEach(System.out::println);

        // 🔍 1. filter(): Employees with salary > 40000
        System.out.println("\nEmployees with salary > 40000:");
        empList.stream()
               .filter(emp -> emp.getSalary() > 40000)
               .forEach(System.out::println);

        // 🔄 2. map(): Get list of employee names in uppercase
        System.out.println("\nEmployee names in UPPERCASE:");
        empList.stream()
               .map(emp -> emp.getName().toUpperCase())
               .forEach(System.out::println);

        // ➕ 3. reduce(): Total salary of all employees
        double totalSalary = empList.stream()
                                    .map(emp -> emp.getSalary())
                                    .reduce(0.0, (a, b) -> a + b);
        System.out.println("\nTotal Salary of All Employees: ₹" + totalSalary);
    }
}
