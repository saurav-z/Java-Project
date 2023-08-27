import java.util.Scanner;

public class SI {
    public static void main(String[] args) {
        double si,r;
        int p,t;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter principal: ");
        p = sc.nextInt();
        System.out.println("Enter time: ");
        t = sc.nextInt();
        System.out.println("Enter rate of interest: ");
        r = sc.nextDouble();
        si = (p * t * r) / 100;
        System.out.println("Simple Interest: " + si);
        sc.close();
    }
}
