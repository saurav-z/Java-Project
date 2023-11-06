package SeventhProject;

import java.util.Scanner;

public class count_vowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String input = sc.nextLine();

        int vowelCount = 0;

        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
        }

        System.out.println("Number of vowels in the string: " + vowelCount);
    }
}
