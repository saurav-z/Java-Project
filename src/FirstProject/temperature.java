import java.util.Scanner;
public class temperature {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Fahrenheit: ");
            double fahrenheit = sc.nextDouble();
            double celsius = (fahrenheit - 32) * 5 / 9;
            System.out.println("Celsius: " + celsius);
        }
}
