package OOP.ResultGenerator;

public class Generate {
    public static void main(String[] args) {
        // Creating three student objects
        int[] marks1 = {90, 85, 92, 88};
        int[] marks2 = {78, 82, 75, 80};
        int[] marks3 = {95, 88, 96, 90};
        Student student1 = new Student("Ram", 18, marks1);
        Student student2 = new Student("Hacke", 19, marks2);
        Student student3 = new Student("Neshan", 17, marks3);

        // Displaying results for each student
        ResultGenerator.displayResults(student1);
        ResultGenerator.displayResults(student2);
        ResultGenerator.displayResults(student3);
    }
}
