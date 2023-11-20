package EighthProject;

import java.util.Scanner;

public class VowelsInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String input = sc.next();
        int len = input.length();
        String vowels="";
        for (int i = 0; i < len; i++) {
            char element = input.charAt(i);

            switch(element){
                case 'a','e','i','o','u','A','E','I','O','U':
                    vowels=vowels.concat(String.valueOf(element));
                    break;
                default:
                    break;


            }
        }
        System.out.println(vowels);
    }
}