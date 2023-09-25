package FifthProject;

import java.util.Scanner;

public class PasswordChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int attempts = 5;
        String correctPass = "admin";

        for (int attempt = 1; attempt <= attempts; attempt++) {
            System.out.print("Enter password (Attempt " + attempt + "): ");
            String userPass = sc.nextLine();

            if (userPass.equals(correctPass)) {
                System.out.println("Access granted!");
                break;
            } else {
                System.out.println("Incorrect password. Try again.");
            }
        }

        if (attempts == 5) {
            System.out.println("Max attempts reached. Access denied.");
        }

        sc.close();
    }
}

