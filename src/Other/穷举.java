package Other;

import java.util.Scanner;

/**
 * Created by lujingyi on 2017/5/24.
 */
//穷举 鸡兔同笼
public class 穷举 {
    static int chiken,rabbit;
    public static int qiongJu(int head,int foot){
        int re=0,i,j;
        for(i=0;i<head;i++){
            j=head-i;//i:鸡，j:兔
            if(i*2+j*4==foot){
                re=1;
                chiken=i;
                rabbit=j;
            }
        }
        return re;
    }
    public static void main(String[] args){
        int re,head,foot;
        System.out.print("请输入头数：");
        Scanner sc=new Scanner(System.in);
        head=sc.nextInt();
        System.out.print("请输入脚数：");
        foot=sc.nextInt();
        re=qiongJu(head,foot);
        if(re==1){
            System.out.println("鸡："+chiken+",兔:"+rabbit);
        }else System.out.println("无解！");
    }
}
