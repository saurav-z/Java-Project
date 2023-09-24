package FourthProject;

import java.util.Scanner;

public class percentage_grade {

        public static void main(String[] args) {
            Scanner inputScanner = new Scanner(System.in);

            System.out.print("Enter the number of subjects: ");
            int numberOfSubjects = inputScanner.nextInt();

            double totalMarks = 0.0;

            for (int i = 1; i <= numberOfSubjects; i++) {
                System.out.print("Enter marks for Subject " + i + ": ");
                double subjectMarks = inputScanner.nextDouble();
                totalMarks += subjectMarks;
            }

            double averageMarks = totalMarks / numberOfSubjects;

            System.out.println("Total marks: " + totalMarks);
            System.out.println("Average marks: " + averageMarks);

            inputScanner.close();
        }

}
