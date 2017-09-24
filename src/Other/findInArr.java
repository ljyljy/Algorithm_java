package Other;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by lujingyi on 2017/5/24.
 */
public class findInArr {
    static int N=20;//静态成员一定不可以写在（局部）方法中！！
    public static void main(String[] args){
        int arr[]=new int[N];
        int flag=-1;

        Random r=new Random();
        for(int i=0;i<N;i++){
            arr[i]=r.nextInt(100);
        }
        System.out.println("生成随机数列：");
        for(int i=0;i<N;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print("\n\n");
        System.out.println("请输入要查找的整数：");
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();

        for(int i=0;i<N;i++){
            if(x==arr[i]){
                flag=i;
                break;
            }
        }
        if(flag<0){
            System.out.println("没有找到"+x);
        }else{
            System.out.println(x+"位于数组第"+(flag+1)+"个!");
        }
//         String str=arr.toString();//这是不行的 会输出类型@哈希值
//         String str=String.valueOf(arr);//这是不行的 会输出类型@哈希值
//        if(str.indexOf(x)==-1){
//            System.out.println("未找到元素！");
//        }else{
//            System.out.println(x+"位于数组第"+(str.indexOf(x)+1)+"个!");//而且 数组转为字符串后 index就混乱了！！故不可取~
//        }


    }
}
