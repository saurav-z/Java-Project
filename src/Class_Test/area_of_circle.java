package Class_Test;

import java.util.Scanner;

public class area_of_circle {
    public static void main(String[] args) {
        double radius,area;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Radius: ");
        radius=sc.nextDouble();
        area=3.141*radius*radius;
        System.out.println("The Area of Circle is: "+area);
    }
}
