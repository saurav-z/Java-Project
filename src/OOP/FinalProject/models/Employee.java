package OOP.FinalProject.models;

public class Employee extends Member {
    String department;

    public Employee(String name, int age, String contact, String address, double salaryPerDay, String department) {
        super(name, age, contact, address, salaryPerDay);
        this.department = department;
    }

}

