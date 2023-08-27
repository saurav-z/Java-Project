import java.util.Scanner;

public class Greatest_Number{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        if (num1 == num2) {
            System.out.println("The numbers are equal.");
        } else {
            int greatest = Math.max(num1, num2);
            System.out.println("The greatest number is: " + greatest);
        }
        scanner.close();
    }
}
