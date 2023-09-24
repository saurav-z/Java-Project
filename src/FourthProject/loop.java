package FourthProject;

public class loop {
    public static void main(String[] args) {

        System.out.println("***For Loop***");
        for (int i=0; i<10; i++) {

            System.out.println(i);
        }

        System.out.println("***While Loop***");
        int i=0;
        while(i<10){
            System.out.println(i);
            i++;
        }
        System.out.println("***Odd Even***");
        for (int j=1;j<=10;j++){
            if (j%2==0) {
                System.out.println(j+" Is Even");
            }
            else{
                System.out.println(j+" Is Odd");
            }
        }


        System.out.println("***Odd Even and Sum***");
        int evensum=0;
        int oddsum=0;
        for (int j=1;j<=10;j++){
            if (j%2==0) {
                System.out.println(j+" Is Even");
                evensum=evensum+j;
            }
            else{
                System.out.println(j+" Is Odd");
                oddsum=oddsum+j;
            }
        }
        if (evensum>oddsum){
            System.out.println("Even Sum "+evensum+" Is Greater");
        } else{
            System.out.println("Odd Sum "+oddsum+" Is Greater");
        }

    }
}
