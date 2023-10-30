package SixthProject;

import java.util.Objects;
import java.util.Scanner;

public class cargame {
    public static void main(String[] args) {
        System.out.println("Let's Drive Car with Code");
        System.out.println("Your Car game is starting.... ");
        Scanner sc= new Scanner(System.in);
        System.out.println("Your Game has started");
        String input;
        int invalid=0;
        while (true) {
            input = sc.next().toLowerCase();
            if (input.equals("hint")){
                System.out.println("1. Start to Start Engine\n2. Stop to Stop Engine\n3. Quit to quit game");
            }
            else if (input.equals("start")){
                System.out.println("Car Started");
            }
            else if (input.equals("stop")){
                System.out.println("Car Stopped");
            }
            else if (input.equals("quit")){
                System.out.println("Game Over");
                break;
            }
            else{
                System.out.println("Invalid Input. Possible Input (Hint)");
            }
            if (invalid==3){
                invalid=0;
                System.out.println("1. Start to Start Engine\n2. Stop to Stop Engine\n3. Quit to quit game");
                
            }
            invalid++;
        }
    }
}
