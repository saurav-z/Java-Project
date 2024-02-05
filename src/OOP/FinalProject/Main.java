//Create a class named 'Member'
//  name
//  age
//  contact
//  address
//  salary(perday) - 24 working days
//print salary(int leaves) - gives salary
// Class 'Manager' int specialization
// Class 'Employee - Department
package OOP.FinalProject;
import OOP.FinalProject.models.Manager;
import OOP.FinalProject.models.Employee;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Hacke", 19, "981234567", "Sifal", 1000.0, "Finance");
        System.out.println("Manager Salary: $" + manager.calculateSalary(2));
        Employee employee = new Employee("Aryan Caudhary", 16, "982121212", "Chakraptah", 80.0, "HR");
        System.out.println("Employee Salary: $" + employee.calculateSalary(3));

    }
}

