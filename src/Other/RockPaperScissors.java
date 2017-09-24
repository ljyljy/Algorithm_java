package Other;

import java.util.Scanner;

/**
 * Created by ljyljy on 2017/7/17.
 */

public class RockPaperScissors {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String ss[]={"Rock","Scissors","Paper"};
//        char ch='Y';

        for(;;){
            System.out.println("Please input a number: 1.Rock   2.Scissors   3.Paper ");
            int player=sc.nextInt();

            if (player>=1&&player<=3){
                int computer=(int)((Math.random()*3)+1);
                System.out.println("You chose "+ss[player-1]);
                System.out.println("Computer chose "+ss[computer-1]);

                if(player==computer){
                    System.out.println("The game ends in a TIE!");
                    System.out.println("Play again?(Y/N)");
                }else if(computer-player==1||player-computer==2){
                    System.out.println("YOU WIN!");
                    System.out.println("Play again?(Y/N)");
                }else{
                    System.out.println("You Lose!");
                    System.out.println("Play again?(Y/N)");
                }
                Scanner sc2=new Scanner(System.in);
                String str=sc2.nextLine();
                if(str.equalsIgnoreCase("N")){
                    break;
                }else if(str.equalsIgnoreCase("Y")){
                    continue;
                }else {
                    System.out.println("Game over.");
                    break;
                }

            }else {
                System.out.println("U input a invalid number!Please input again！\n");
            }
        }
//        Random r=new Random();
//        int computer=r.nextInt(3)+1;



    }

}
