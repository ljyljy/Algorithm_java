package Other;

import java.util.Scanner;

/**
 * Created by lujingyi on 2017/5/24.
 */
//Java常用算法 p111
public class 分治找假币 {
    static final int MAXNUM=30;
    public static int falseCoin(int coin[],int low,int high){
        int i,sum1=0,sum2=0,sum3=0,re=0;
        if(low+1==high){
            if(coin[low]<coin[high]){
                re=low+1;
                return re;
            }
            else if(coin[low]>coin[high]){
                re=high+1;
                return re;
            }
//            else
//            {
//                re=-1;
//                return re;
//            }
        }
        if((high-low+1)%2==0){//n为偶数
            for(i=low;i<=low+(high-low)/2;i++){//前半段和；注意i的起始位置为low！！（不是0！！！）
                sum1+=coin[i];
            }
            for(i=low+(high-low)/2+1;i<=high;i++){//后半段和
                sum2+=coin[i];
            }
            if(sum1>sum2){//从后半段再找假币
                re=falseCoin(coin,low+(high-low)/2+1,high);
                return re;//勿忘return！！！！
            }else if(sum1<sum2){//从前半段再找假币
                re=falseCoin(coin,low,low+(high-low)/2);//注意i的起始位置为low！！（不是0！！！）
                return re;
            }
//            else {
//                re=-1;
//                return re;
//            }
        }
        else//n为奇数
        {
            for(i=low;i<=low+(high-low)/2-1;i++){//前半段和；注意i的起始位置为low！！（不是0！！！）
                sum1+=coin[i];
            }
            for(i=low+(high-low)/2+1;i<=high;i++){//后半段和
                sum2+=coin[i];
            }

            if(sum1>sum2){
                re=falseCoin(coin,low+(high-low)/2+1,high);
                return re;
            }else if(sum1<sum2){
                re=falseCoin(coin,low,low+(high-low)/2-1);//注意起始位置为low！！（不是0！！！）
                return re;
            }
            else {

            }
            sum3=coin[low+(high-low)/2];//奇数段中点值
            if(sum1==sum2){//if一定要在else外面写！！！！！！
                re=sum3;
                return re;
            }

        }
        return re;
    }
    public static void main(String[] args){
        int coin[]=new int[MAXNUM];
        int i,n,index;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.print("请输入硬币总个数（<=30）");
            n=sc.nextInt();
        }while (n>30);

        System.out.println("请输入硬币真假（真>假）：");
        for(i=0;i<n;i++){
            coin[i]=sc.nextInt();
        }
        index=falseCoin(coin,0,n-1);

        System.out.println("在"+n+"个硬币中，第"+index+"个是假币！");
    }
}
