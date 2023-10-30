package Class_Test;

import java.util.Scanner;

public class sum_odd_even_ten {
    public static void main(String[] args) {
        int odd=0,even=0;
        for (int i=1;i<=10;i++){
            if (i%2==0){
                even=even+i;
            }
            else{
                odd=odd+i;
            }
        }
        System.out.println("Sum of Odd is "+odd+" and that of even is "+even);
    }
}
