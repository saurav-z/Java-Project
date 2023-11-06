package SeventhProject;

import java.util.Scanner;

public class login_advanced {
    public static void main(String[] args) {
    String correctuser="admin";
    String correctpass="@1234567";
    Scanner sc=new Scanner(System.in);
        System.out.println("Enter username");
        String username=sc.next();
        System.out.println("Enter password");
        String password=sc.next();
        if (correctuser.equals(username)&&correctpass.equals(password)&&(password.length()==8)&&(password.indexOf('@')!=-1)){
            System.out.println("You are logged in");
        }else{
            System.out.println("Please check your password");
        }



    }
}
