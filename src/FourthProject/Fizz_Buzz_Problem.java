package FourthProject;

import java.util.Scanner;

public class Fizz_Buzz_Problem {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter Number");
        double checkd= scan.nextDouble();
        int check=(int)(checkd);
        if (check %5==0 && check%3==0){
            System.out.println("Fizz-Buzz");
        }
        else  if (check%3==0){
            System.out.println("Fizz");}
            else if (check %5==0){
                System.out.println("Buzz");
            }

            else {
            System.out.println(check);
        }
    }
}
