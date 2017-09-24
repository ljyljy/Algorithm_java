package Other;

import java.util.Scanner;

/**
 * Created by lujingyi on 2017/5/24.
 */
public class 近似PI
{
    static double MontePI(int n){
        int i,sum=0;
        double x,y,PI;
        for(i=0;i<n;i++){
            x=Math.random();
            y=Math.random();
            if((x*x+y*y<=1)){
                sum++;
            }
          // ∵（1/4圆 第一象限上）S阴影：S正方形=(4.0/PI) / (1*1)= n（总点数）：sum（落在1/4圆中的点数）;
            // 由上式 推算出PI的表达式
        }
        PI=4.0*sum/n;//PI不可写在局部for循环中！！！
        //勿忘‘.0’！！！！！
        return PI;
    }
    public static void main(String[] args){
        int n;
        double PI;
        System.out.print("请输入撒点总数n：");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        PI=MontePI(n);
        System.out.println("MonteCarlo计算PI的近似值为："+PI);
    }
}
