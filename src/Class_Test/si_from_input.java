package Class_Test;

import java.util.Scanner;

public class si_from_input {
    public static void main(String[] args) {
        double principle, rate, time, si;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Principle");
        principle=sc.nextDouble();
        System.out.println("Enter Rate");
        rate=sc.nextDouble();
        System.out.println("Enter Time");
        time=sc.nextDouble();
        si=(principle*rate*time)/100;
        System.out.println("The SI is "+si);

    }
}
