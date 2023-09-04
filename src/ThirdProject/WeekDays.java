package ThirdProject;

import java.util.Scanner;

public class WeekDays {
    public static void main(String[] args) {
        int day_no;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter day in number:");
        day_no= sc.nextInt();
        switch (day_no) {
            case 1 -> System.out.println("Sunday");
            case 2 -> System.out.println("Monday");
            case 3 -> System.out.println("Tuesday");
            case 4 -> System.out.println("Wednesday");
            case 5 -> System.out.println("Thursday");
            case 6 -> System.out.println("Friday");
            case 7 -> System.out.println("Saturday");
            default -> System.out.println("Invalid Input");
        }
    }

}
