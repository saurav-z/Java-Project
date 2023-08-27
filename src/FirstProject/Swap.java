import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        int num1,num2,num3;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first number:");
        num1=sc.nextInt();
        System.out.println("Enter second number:");
        num2=sc.nextInt();
        System.out.println("Number Before Swapping is:" + num1 + num2);
        num3=num1;
        num1=num2;
        num2=num3;
        System.out.println("Swapped Number is:" + num1 + num2);
        sc.close();
    }
}
