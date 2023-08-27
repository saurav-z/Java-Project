import java.util.Scanner;
public class Add_Two_Numbers {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the first number: ");
            int num1 = scanner.nextInt();
            System.out.println("Enter the second number: ");
            int num2 = scanner.nextInt();
            int sum = num1 + num2;
            System.out.println("Sum: " + sum);
            scanner.close();
        }
}
