import java.util.Scanner;

public class Taking_Input {
    public static void main(String[] args) {
        String name;
        //creating object of scanner
        Scanner sc=new Scanner(System.in);
        //displaying message for input
        System.out.println("Enter your name:");
        //taking the value from input and storing in variable
        name=sc.next();
        System.out.println("The name is " + name);
        sc.close();
    }
}
