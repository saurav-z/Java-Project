package ThirdProject;

import java.util.Scanner;

public class GreatestNumberBetweenThree {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();
            System.out.print("Enter the third number: ");
            int num3 = scanner.nextInt();

            int max = num1;

            if (num2 > max) {
                max = num2;
            }

            if (num3 > max) {
                max = num3;
            }

            System.out.println("The greatest number is: " + max);
        }
    }

