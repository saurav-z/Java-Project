import java.util.Scanner;

    public class Grading_System {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter marks for Subject 1: ");
            double subject1 = scanner.nextDouble();
            System.out.print("Enter marks for Subject 2: ");
            double subject2 = scanner.nextDouble();
            System.out.print("Enter marks for Subject 3: ");
            double subject3 = scanner.nextDouble();
            double totalMarks = subject1 + subject2 + subject3;
            double percentage = (totalMarks / 300) * 100;
            char grade;
            if (percentage >= 90) {
                grade = 'A';
            } else if (percentage >= 80) {
                grade = 'B';
            } else if (percentage >= 70) {
                grade = 'C';
            } else if (percentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Percentage: " + percentage + "%");
            System.out.println("Grade: " + grade);
            scanner.close();
        }
    }


