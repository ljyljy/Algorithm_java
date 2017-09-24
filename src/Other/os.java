package Other;

import java.util.Scanner;

public class os {
    public static void main(String[] args){
            int n, i, j;
            String a,b;
            Scanner sc=new Scanner(System.in);
            n=sc.nextInt();
            for(i = 1; i <= n; i++){
                Scanner sc2=new Scanner(System.in);
                while(sc2.hasNextLine())
                {
                    System.out.println("Case "+i+":"+"\n");
                    a=sc2.nextLine();
                    b=sc2.nextLine();
                    System.out.print(a+"\n"+b);
                }
            }




    }
}
