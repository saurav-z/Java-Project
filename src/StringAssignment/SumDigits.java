package StringAssignment;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number=sc.nextInt();
        int mod,sum=0;
        while (number!=0){
            mod=number%10;    // gives last number as output
            sum=sum+mod;
            number=number/10;   // Removes last number from given number
        }
        System.out.println("The sum of digits og given number is: "+sum);
    }
}
