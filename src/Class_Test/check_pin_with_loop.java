package Class_Test;

import java.util.Scanner;

public class check_pin_with_loop {
    public static void main(String[] args) {
        int correctPin=1234,i=1, enteredPin;
        Scanner sc=new Scanner(System.in);
        System.out.println("You have 3 attempts");
        while(i<=3){
            System.out.println("Enter your Pin: ");
            enteredPin=sc.nextInt();
            if (enteredPin==correctPin){
                System.out.println("You are Logged in");
                break;
            }
            else{
                System.out.println("Attempt: "+i);
                System.out.println("Try Again");
                i++;
            }
        }
    }
}

