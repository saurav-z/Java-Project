import java.util.Scanner;
public class Area {
    public static void main(String[] args) {
        int length,breadth,area;
        Scanner sc=new Scanner(System.in);
        length= sc.nextInt();
        breadth=sc.nextInt();
        area=length*breadth;
        System.out.println(area);
        sc.close();
    }
}
