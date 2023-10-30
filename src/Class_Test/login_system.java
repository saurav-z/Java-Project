package Class_Test;

import java.util.Random;
import java.util.Scanner;

public class login_system {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String User = "admin";
        String Pass = "user";
        System.out.print("Enter username: ");
        String username = scan.nextLine();
        System.out.print("Enter password: ");
        String password = scan.nextLine();
        if (username.equals(User) && password.equals(Pass)) {
            System.out.println("Welcome to Your Tools Collection!");
            System.out.println("What do you want to do today?");
            int whichtool;
            do {
                System.out.println("**********************");
                System.out.println("0. Exit");
                System.out.println("1. Calculator");
                System.out.println("2. Guessing Game");
                System.out.println("3. SI Calculator");
                System.out.println("4. Vowel Consonant Check");

                whichtool = scan.nextInt();

                switch (whichtool) {
                    case 1:
                        System.out.println("You choose Calculator");
                        System.out.print("Enter Operation (+,-,*,/): ");
                        String operation = scan.next();
                        System.out.print("First Number: ");
                        double firstn = scan.nextDouble();
                        System.out.print("Second Number: ");
                        double secondn = scan.nextDouble();
                        double num1, num2;
                        double great = Math.max(firstn, secondn);
                        if (great == firstn) {
                            num1 = firstn;
                            num2 = secondn;
                        } else if (great == secondn) {
                            num2 = firstn;
                            num1 = secondn;
                        } else {
                            num1 = firstn;
                            num2 = secondn;
                        }
                        switch (operation) {
                            case "+" -> System.out.println("The sum is:" + (firstn + secondn));
                            case "-" -> System.out.println("The difference is:" + (num1 - num2));
                            case "*" -> System.out.println("The result is:" + (num1 * num2));
                            case "/" -> System.out.println("The division is:" + (num1 / num2));
                            default -> System.out.println("Operation Not Found");
                        }
                        break;
                    case 2:
                        Random random = new Random();
                        int targetNumber = random.nextInt(6);

                        System.out.println("You Choose Guessing Game!");
                        while (true) {
                            System.out.print("Enter your guess (1-5): ");
                            int guess = scan.nextInt();
                            if (guess == targetNumber) {
                                System.out.println("Your Guess is Correct");
                                break;
                            } else if (guess < targetNumber) {
                                System.out.println("Try High.");
                            } else {
                                System.out.println("Try Low.");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("You choose SI Calculator");
                        System.out.println("Enter Principle: ");
                        double principle = scan.nextDouble();
                        System.out.println("Enter Time");
                        double time = scan.nextDouble();
                        System.out.println("Enter Rate");
                        double rate = scan.nextDouble();

                        double si = (principle * time * rate) / 100;
                        System.out.println("SI is" + si);
                        break;

                    case 4:
                        System.out.println("You choose Vowel Consonant Check");
                        System.out.println("Enter a character");
                        String character = scan.nextLine().toLowerCase();
                        if (character.length() == 1) {
                            switch (character) {
                                case "a", "e", "i", "o", "u":
                                    System.out.println("It is Vowel");
                                    break;
                                default:
                                    System.out.println("It is Consonant");
                                    break;
                            }
                        } else {
                            System.out.println("Enter only one valid character");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            } while (whichtool != 0);

        } else {
            System.out.println("Invalid Login!");
        }
    }
}
