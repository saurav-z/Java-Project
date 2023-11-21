package EighthProject;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter String: ");
            String input = sc.next();
            int len = input.length();
            String original = input;
            String reverse = "";
            if (input.toLowerCase().equals("exit")){
                break;
            }
            for (int i = len - 1; i >= 0; i--) {
                char element = input.charAt(i);
                reverse = reverse.concat(String.valueOf(element));
            }
            if (reverse.equals(original)) {
                System.out.println("Its Palindrome number");
            } else {
                System.out.println("Its not Palindrome");
            }
            System.out.println("Type Exit to Stop Program");
        }
    }
}
