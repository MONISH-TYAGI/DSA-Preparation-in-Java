//Ques->https://www.pepcoding.com/resources/online-java-foundation/patterns/design-pattern-11-official/ojquestion

//Code->
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int count=1;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
           { System.out.print(count+"	");
            count++;}
        
        System.out.println();
    }}
}