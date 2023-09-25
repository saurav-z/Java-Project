package FifthProject;

import java.util.Scanner;

public class ResultGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of marks to enter: ");
        int noofmarks = sc.nextInt();

        double totalMarks = 0;

        for (int i = 1; i <= noofmarks; i++) {
            System.out.print("Enter mark for subject" + i + ": ");
            double studentMark = sc.nextDouble();
            totalMarks = totalMarks + studentMark;
        }

        double averageMark = totalMarks / noofmarks;

        System.out.println("-------- Result --------");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Mark: " + averageMark);
    }
}

