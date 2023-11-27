package NinthProject;

import java.sql.SQLOutput;
import java.util.Scanner;

public class EmailAddressGenerator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("First Name: ");
        String first=sc.next();
        System.out.print("Last Name: ");
        String last=sc.next();
        System.out.println("Mail Server Domain (example.(com/org/edu)): ");
        String domain=sc.next();
        if ((domain.contains("com"))||(domain.contains("org"))||(domain.contains("edu"))){
            String email = first.toLowerCase()+"."+last.toLowerCase()+"@"+domain.toLowerCase();
            System.out.println(email);
        }
        else{
            System.out.println("Domain not allowed");
        }


    }
}
