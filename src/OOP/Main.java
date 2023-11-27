package OOP;

import OOP.models.Student;
import OOP.models.Section;

public class Main {
    public static void main(String[] args) {
        // Make new Object from Student Class
        Student std1 = new Student();
        //Get default values from created object
        System.out.println(std1.getName());
        System.out.println(std1.getAge());
        // Set Values in created object
        std1.setName("Saurav");
        std1.setAge(18);
        // Print New Values
        System.out.println(std1.getName());
        System.out.println(std1.getAge());
        // Make new Object from Section Class
        Section sc = new Section();
        //Get default values from created object
        System.out.println(sc.getName());
        System.out.println(sc.getRoom_no());
        System.out.println(sc.getCollege());
        // Set Values in created object
        sc.setName("Yala");
        sc.setRoom_no(102);
        // Print New Values
        System.out.println(sc.getName());
        System.out.println(sc.getRoom_no());
        System.out.println(sc.getCollege());
    }
}
