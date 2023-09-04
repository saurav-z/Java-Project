package FourthProject;

import java.util.Scanner;

public class Weekends {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter Day Number(1-7)");
        double day_no= scan.nextDouble();
        int dayno= (int) (day_no);
        switch (dayno){
            case 2,3,4,5,6 -> System.out.println("Weekday");
            case 1,7 -> System.out.println("Weekend");
            default -> System.out.println("Invalid Input");
        }
    }


}
