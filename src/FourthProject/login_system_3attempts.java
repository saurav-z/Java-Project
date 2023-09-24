package FourthProject;

import java.util.Scanner;

public class login_system_3attempts {
    public static void main(String[] args) {
        String correctuser = "hacke";
        String correctpass = "admin";

        int loginAttempts = 0;

        Scanner inputScanner = new Scanner(System.in);

        while (loginAttempts < 3) {
            System.out.print("Login: ");
            String entereduser = inputScanner.nextLine();

            System.out.print("Password: ");
            String enteredPass = inputScanner.nextLine();

            if (entereduser.equals(correctuser) && enteredPass.equals(correctpass)) {
                System.out.println("Login successful!");
                break;
            } else {
                System.out.println("Login failed. Please try again.");
                loginAttempts++;
            }
        }

        if (loginAttempts == 3) {
            System.out.println("Please Try Again Later.");
        }
    }
}
