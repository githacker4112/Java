import java.util.Arrays;
import java.util.Scanner;

class Staff {
    int id;
    String name, dob, joinDate;
    double salary;

    public Staff(int id, String name, String dob, String joinDate, double salary) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.joinDate = joinDate;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", DOB: " + dob +
                ", Join Date: " + joinDate + ", Salary: " + salary);
    }
}

class TeachingStaff extends Staff {
    String[] subjects;
    int experience;

    public TeachingStaff(int id, String name, String dob, String joinDate, double salary,
                         String[] subjects, int experience) {
        super(id, name, dob, joinDate, salary);
        this.subjects = subjects;
        this.experience = experience;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Subjects: " + Arrays.toString(subjects) + ", Experience: " + experience + " years");
    }
}

class NonTeachingStaff extends Staff {
    String department, shift;

    public NonTeachingStaff(int id, String name, String dob, String joinDate, double salary,
                             String department, String shift) {
        super(id, name, dob, joinDate, salary);
        this.department = department;
        this.shift = shift;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Department: " + department + ", Shift: " + shift);
    }
}

public class DeptStaff {
    public static void main(String[] args) {
        Staff[] staffArray = new Staff[4];

        staffArray[0] = new TeachingStaff(
                101, "Ravi", "10-01-1985", "12-06-2010", 45000.0,
                new String[]{"Math", "Physics"}, 12);

        staffArray[1] = new TeachingStaff(
                102, "Neha", "25-03-1987", "01-01-2015", 40000.0,
                new String[]{"Biology"}, 8);

        staffArray[2] = new NonTeachingStaff(
                201, "Seema", "05-11-1990", "15-07-2012", 30000.0,
                "Admin", "Morning");

        staffArray[3] = new NonTeachingStaff(
                202, "Amit", "22-04-1992", "18-09-2014", 28000.0,
                "Accounts", "Evening");

        System.out.println("------- Staff Details -------");
        for (Staff s : staffArray) {
            s.display();
            System.out.println("----------------------------");
        }
    }
}
