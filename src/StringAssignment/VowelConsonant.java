package StringAssignment;

import java.util.Scanner;

public class VowelConsonant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String input = sc.next();
        int len = input.length();
        int vowels=0,consonant=0;
        for (int i = 0; i < len; i++) {
            char element = input.charAt(i);

            switch(element){
                case 'a','e','i','o','u','A','E','I','O','U':
                    vowels=vowels+1;
                    break;
                default:
                    consonant=consonant+1;
                    break;


            }
        }
        System.out.println("Number of Vowels:"+vowels+" and Number of Consonants:"+consonant);
    }
}
