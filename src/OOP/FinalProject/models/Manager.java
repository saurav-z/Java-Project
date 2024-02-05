package OOP.FinalProject.models;

public class Manager extends Member {
    String specialization;

    public Manager(String name, int age, String contact, String address, double salaryPerDay, String specialization) {
        super(name, age, contact, address, salaryPerDay);
        this.specialization = specialization;
    }
    }
