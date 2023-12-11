package OOP;

import OOP.models.Mammals;
import OOP.models.Student;
import OOP.models.Section;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
                // Make new Object from Student Class
        // Create the first student
        Student std1 = new Student();
        // Set values for the first student
        std1.setName("Saurav");
        std1.setAge(18);
        std1.setGender("Male");
        std1.setGrade(12);
        std1.setSection("Yala");

        // Print the new values for the first student
        System.out.println("New values for Student 1:");
        System.out.println("Name: " + std1.getName());
        System.out.println("Age: " + std1.getAge());
        System.out.println("Gender: "+ std1.getGender());
        System.out.println("Grade: "+ std1.getGrade());
        System.out.println("Section: "+ std1.getSection());

        // Create three more students
        Student std2 = new Student();
        Student std3 = new Student();
        Student std4 = new Student();

        // Set values for the other three students
        std2.setName("Alice");
        std2.setAge(17);
        std2.setGender("Female");
        std2.setGrade(11);
        std2.setSection("Xin");

        std3.setName("Bob");
        std3.setAge(18);
        std3.setGender("Male");
        std3.setGrade(12);
        std3.setSection("Zara");

        std4.setName("Eva");
        std4.setAge(16);
        std4.setGender("Female");
        std4.setGrade(10);
        std4.setSection("Woka");

        // Print values for the other three students
        System.out.println("\nValues for Student 2:");
        System.out.println("Name: " + std2.getName());
        System.out.println("Age: " + std2.getAge());
        System.out.println("Gender: "+ std2.getGender());
        System.out.println("Grade: "+ std2.getGrade());
        System.out.println("Section: "+ std2.getSection());

        System.out.println("\nValues for Student 3:");
        System.out.println("Name: " + std3.getName());
        System.out.println("Age: " + std3.getAge());
        System.out.println("Gender: "+ std3.getGender());
        System.out.println("Grade: "+ std3.getGrade());
        System.out.println("Section: "+ std3.getSection());

        System.out.println("\nValues for Student 4:");
        System.out.println("Name: " + std4.getName());
        System.out.println("Age: " + std4.getAge());
        System.out.println("Gender: "+ std4.getGender());
        System.out.println("Grade: "+ std4.getGrade());
        System.out.println("Section: "+ std4.getSection());







                // Make new Object from Section Class
        Section sc = new Section();
        //Get default values from created object
        System.out.println(sc.getCollege());
        // Set Values in created object
        sc.setName("Yala");
        sc.setRoom_no(102);
        // Print New Values
        System.out.println(sc.getName());
        System.out.println(sc.getRoom_no());
        System.out.println(sc.getCollege());






              // Make new Object from Mammals Class
        Mammals human=new Mammals();
        System.out.println(human.getNo_of_chambers());
        human.setNo_of_chambers(12);
        System.out.println(human.getNo_of_chambers());
        System.out.println("Is warm Blooded: "+human.isWarmBlooded());

    }
}
