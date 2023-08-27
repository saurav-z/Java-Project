package ThirdProject;

import java.util.Scanner;

public class HighestPossibleNote {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int amount = scanner.nextInt();

            int[] notes = {1000, 500, 100, 50, 20, 10, 5, 2, 1};

            System.out.println("Highest note:");

            for (int note : notes) {
                if (amount >= note) {
                    int count = amount / note;
                    System.out.println(count + "-" + note + " note");
                    amount = amount % note;
                }
            }

            if (amount > 0) {
                System.out.println("Other: " + amount);
            }
        }

}

