package Other;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lujingyi on 2017/5/25.
 */
public class 各种数组快速排序 {
    static final int SIZE=10;
    static void quickSortInt(int[] arr,int left,int right){
        int f,tmp;
        int rtemp,ltemp;

        ltemp=left;
        rtemp=right;
        f=arr[(right+left)/2];//分界值
        while (ltemp<rtemp){
            while (arr[ltemp]<f){//当找到左半段有比分界值f大者，跳出此while，进入下面的if
                ++ltemp;
            }
            while (arr[rtemp]>f){//当找到右半段有比分界值f小者，跳出此while，进入下面的if
                --rtemp;
            }
            if(ltemp<=rtemp){//上方while被中断 是因为arr[ltemp]>f>arr[rtemp]
                // 此时 需要交换arr[ltemp]和arr[rtemp]的值
                tmp=arr[ltemp];
                arr[ltemp]=arr[rtemp];
                arr[rtemp]=tmp;
                ++ltemp;
                --rtemp;
            }
        } //跳出while循环后 ltemp>=rtemp，若相等 则ltemp++；
        // 然后对分界值的左右子列同时再递归调用
        if(ltemp==rtemp){
            ltemp++;
        }
        if(ltemp<right){
            quickSortInt(arr,rtemp+1,right);//对右半段 递归调用 再排序
        }
        if(rtemp>left){
            quickSortInt(arr,left,ltemp-1);//对左半段 递归调用 再排序
        }
    }
    //字符串数组的快速排序
    static void quickSortStr(String[] arr,int left,int right) {
        String f,tmp;
        int rtemp,ltemp;

        ltemp=left;
        rtemp=right;
        f=arr[(right+left)/2];//分界值
        while (ltemp<rtemp){
            while (arr[ltemp].compareTo(f)<0){//当找到左半段有比分界值f大者，跳出此while，进入下面的if
                ++ltemp;
            }
            while (arr[rtemp].compareTo(f)>0){//当找到右半段有比分界值f小者，跳出此while，进入下面的if
                --rtemp;
            }
            if(ltemp<=rtemp){//上方while被中断 是因为arr[ltemp]>f>arr[rtemp]
                // 此时 需要交换arr[ltemp]和arr[rtemp]的值
                tmp=arr[ltemp];
                arr[ltemp]=arr[rtemp];
                arr[rtemp]=tmp;
                ++ltemp;
                --rtemp;
            }
        } //跳出while循环后 ltemp>=rtemp，若相等 则ltemp++；
        // 然后对分界值的左右子列同时再递归调用
        if(ltemp==rtemp){
            ltemp++;
        }
        if(ltemp<right){
            quickSortStr(arr,rtemp+1,right);//对右半段 递归调用 再排序
        }
        if(rtemp>left){
            quickSortStr(arr,left,ltemp-1);//对左半段 递归调用 再排序
        }
    }
    public static void printArr(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(" "+a[i]);
        }
    }
    public static void printArr(String[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(" "+a[i]);
        }
    }
    public static void main(String[] args){
        int[] arr=new int[SIZE];
        int i;
        for(i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*(100+1));
        }
        System.out.println("-------------Int[]的快速排序------------");
        System.out.println("排序前int数组：");
        printArr(arr);
        System.out.println("\n快速排序后int数组：");
        quickSortInt(arr,0, arr.length-1);
        printArr(arr);
        System.out.println("\n\n----------String[]的快速排序-------------");
        String[] str=new String[]{"One","World","Dream","Beijing","Olympic"};
        System.out.println("排序前String数组：");
        printArr(str);
        System.out.println("\n快速排序后String数组：");
        quickSortStr(str,0, str.length-1);
        printArr(str);
//法2：
        String[] str2=new String[]{"One","World","Dream","Beijing","Olympic"};
        Arrays.sort(str2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });//Arrays.sort（obj[] obj,comparator）（只要是数组 无论什么种类都可以sort！）
        System.out.println("\n\n----------Arrays.sort(..)定制排序-------------");
        printArr(str2);
    }
}
