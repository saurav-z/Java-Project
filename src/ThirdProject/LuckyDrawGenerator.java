package ThirdProject;

import java.util.Random;
import java.util.Scanner;

public class LuckyDrawGenerator {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter participant names (with comma): ");
            String parti = scanner.nextLine();

            String[] partis = parti.split(",");
            for (int i = 0; i < partis.length; i++) {
                partis[i] = partis[i].trim();
            }

            if (partis.length == 0) {
                System.out.println("No participants entered.");
            } else {
                Random rand = new Random();
                int win = rand.nextInt(partis.length);

                System.out.println("Lucky Draw Winner: " + partis[win]);
            }
        }


}
