package EighthProject;
import java.util.Scanner;

public class ListElementsString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String: ");
        String input=sc.next();
        int len=input.length();
        for(int i=0;i<len;i++){
            char element=input.charAt(i);
            System.out.print(element);

        }
    }
    }
