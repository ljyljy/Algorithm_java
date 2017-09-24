package Other;

import java.util.Scanner;

/**
 * Created by lujingyi on 2017/5/24.
 */
public class 递归阶乘 {
    public static long fact(int n){
        if(n<1) {
            return 1;
        }
        else {
            return n*fact(n-1);
        }
    }
    public static void main(String[] args){
        System.out.print("请输入阶乘的n：");
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        System.out.println(i+"! = "+fact(i));
    }
}
