package NinthProject;

import java.io.FileReader;
import java.util.Scanner;

public class FullNameDisplay {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("First Name");
        String first=sc.next();
        System.out.println("Last Name");
        String last=sc.next();
        System.out.println("Full Name: "+ first +" "+last);

    }
}

