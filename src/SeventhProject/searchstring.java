package SeventhProject;

import java.util.Scanner;

public class searchstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter long sentence");
        String sentence = sc.nextLine();

        System.out.println("Enter the word or string to search for:");
        String searchWord = sc.next();
        if (sentence.contains(searchWord)) {
            System.out.println("The sentence contains the word '" + searchWord + "'.");
        } else {
            System.out.println("The sentence does not contain the word '" + searchWord + "'.");
        }
    }
}
